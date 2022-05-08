package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Common.Common;
import com.example.myapplication.HolderItemView.EmployeeHolder;
import com.example.myapplication.Interface.ItemViewHolder;
import com.example.myapplication.entity.Employee;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FinishActivity extends AppCompatActivity {

   private TextView txtFinish;
    private FirebaseDatabase database;
    private DatabaseReference employee;
    private RecyclerView recycler_employee;
    private RecyclerView.LayoutManager gridLayoutManager;
    private ImageButton btnAdd, btnDelete,btnUpload;
    FirebaseRecyclerAdapter<Employee, EmployeeHolder> adapter_employee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //set keyId
        txtFinish=findViewById(R.id.textView2);
        txtFinish.setText(Common.currentUser.getName());


        btnAdd=findViewById(R.id.imageButton4);
        btnDelete=findViewById(R.id.imageButton7);
        btnUpload=findViewById(R.id.imageButton6);

        //btn Activity
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FinishActivity.this,FormAddActivity.class);
                startActivity(intent);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FinishActivity.this,FormUploadActivity.class);
                //lay id
                startActivity(intent);
            }
        });
        //Init Firebase
        database=FirebaseDatabase.getInstance();
        employee=database.getReference("Employee");

        //Load employee
        recycler_employee=findViewById(R.id.recyclerView);
        recycler_employee.setHasFixedSize(true);
        gridLayoutManager = new GridLayoutManager(getApplicationContext(),1, LinearLayoutManager.VERTICAL,false);
        recycler_employee.setHorizontalScrollBarEnabled(false);
        recycler_employee.setLayoutManager(gridLayoutManager);

        loadEmployee();
    }

    private void loadEmployee() {
        adapter_employee=new FirebaseRecyclerAdapter<Employee, EmployeeHolder>(Employee.class,R.layout.item_employee,EmployeeHolder.class,employee) {
            @Override
            protected void populateViewHolder(EmployeeHolder employeeHolder, Employee employee, int i) {

                //set view
                employeeHolder.txtName.setText(employee.getName());
                employeeHolder.txtAdrress.setText(employee.getAddress());
                employeeHolder.txtPhone.setText(employee.getPhone());
                employeeHolder.txtAge.setText(employee.getAge());
                final Employee clickItem=employee;
                employeeHolder.setItemViewHolder(new ItemViewHolder() {
                    @Override
                    public void OnClick(View view, int posititon, boolean isLongClick) {
                        Toast.makeText(FinishActivity.this, "" + clickItem.getName(), Toast.LENGTH_LONG).show();
                        Intent foodList=new Intent(FinishActivity.this,FormUploadActivity.class);
                        foodList.putExtra("EmployeeId",adapter_employee.getRef(posititon).getKey());
                        startActivity(foodList);
                    }
                });
            }
        };
        recycler_employee.setAdapter(adapter_employee);
    }
}