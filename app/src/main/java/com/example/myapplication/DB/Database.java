package com.example.myapplication.DB;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.myapplication.entity.Employee;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {
    private static final String DB_NAME="Employee.sqlite";
    private static final int DB_VER=1;
    public Database(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }
@SuppressLint("Range")
public List<Employee> getCart(){
        SQLiteDatabase db=getReadableDatabase();
    SQLiteQueryBuilder qb=new SQLiteQueryBuilder();

    String[] sqlSelect={"name","phone","address","age"};
    String sqlTable="employee";

    qb.setTables(sqlTable);
    Cursor c=qb.query(db,sqlSelect,null,null,null,null,null);

    final List<Employee> result=new ArrayList<>();
    if (c.moveToFirst()){
        do {
            result.add(new Employee(
                    c.getString(c.getColumnIndex("name")),
                    c.getString(c.getColumnIndex("phone")),
                    c.getString(c.getColumnIndex("address")),
                    c.getString(c.getColumnIndex("age"))
            ));
        }while (c.moveToNext());
    }
        return result;
}
    @SuppressLint("Range")
    public Employee getCartByAll(int id){
        SQLiteDatabase db=getReadableDatabase();
        SQLiteQueryBuilder qb=new SQLiteQueryBuilder();

        String[] sqlSelect={"employeeId","name","phone","address","age"};
        String sqlTable="employee";

        qb.setTables(sqlTable);
        Cursor cursor = qb.query(db,sqlSelect, "employeeId" + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Employee user = new Employee(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
        // return contact
        return user;
    }
public void addToCart(Employee order){
        SQLiteDatabase db=getReadableDatabase();
        String query=String.format("INSERT INTO employee(name,phone,address,age) VALUES('%s','%s','%s','%s');",
                order.getName(),
                order.getPhone(),
                order.getAddress(),
                order.getAge());
        db.execSQL(query);
}
    public int updateUse(Employee user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("phone", user.getPhone());
        values.put("address", user.getAddress());
        values.put("age", user.getAge());


        // updating row
        String sqlTable="employee";
        return db.update(sqlTable, values, "employeeId" + " = ?",
                new String[] { String.valueOf(user.getEmployeeId()) });
    }
    public int deleteUser(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        String sqlTable="employee";
        return db.delete(sqlTable, "employeeId" + " = ?",
                new String[] { String.valueOf(id) });

    }
    public void deleteToCart(){
        SQLiteDatabase db=getReadableDatabase();
        String query=String.format("DELETE FROM employee");
        db.execSQL(query);
    }
    public void deleteToCartByIdOrder(){
        SQLiteDatabase db=getReadableDatabase();
        String query=String.format("DELETE FROM employee");
        db.execSQL(query);
    }

}
