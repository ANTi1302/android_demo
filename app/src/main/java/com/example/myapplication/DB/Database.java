package com.example.myapplication.DB;

import android.annotation.SuppressLint;
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
public void addToCart(Employee order){
        SQLiteDatabase db=getReadableDatabase();
        String query=String.format("INSERT INTO employee(name,phone,address,age) VALUES('%s','%s','%s','%s');",
                order.getName(),
                order.getPhone(),
                order.getAddress(),
                order.getAge());
        db.execSQL(query);
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
