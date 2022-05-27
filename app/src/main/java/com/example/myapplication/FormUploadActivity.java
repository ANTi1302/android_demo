package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.entity.Employee;

public class FormUploadActivity extends AppCompatActivity {
    TextView txtName,txtPhone,txtAddress,txtAge;
    Button btnUpload,btnDelete;
    private String empId="";

    Employee currentemp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_upload);

        //get id
        txtPhone= findViewById(R.id.phoneUp);
        txtAddress= findViewById(R.id.addressUp);
        txtAge=findViewById(R.id.ageUp);
        txtName=findViewById(R.id.nameUp);
        btnUpload=findViewById(R.id.uploadEmplyee);
        btnDelete=findViewById(R.id.delete);
        //Init Firebase

        //Get intent here
        if (getIntent()!=null){
            empId=getIntent().getStringExtra("EmployeeId");


        }if (!empId.isEmpty()&&empId!=null){

        }

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




            }
        });

    }


}