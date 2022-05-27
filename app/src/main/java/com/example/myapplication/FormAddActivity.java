package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.DB.Database;
import com.example.myapplication.entity.Employee;

public class FormAddActivity extends AppCompatActivity {
    private String employeeId;
    private Employee employee;
    private TextView txtName,txtPhone,txtAdd,txtAge;
    private Button btnAdd;
    private String employeeID="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_add);

        //set Id
        txtName=findViewById(R.id.nameAdd);
        txtPhone=findViewById(R.id.phoneAdd);
        txtAdd=findViewById(R.id.addressAdd);
        txtAge=findViewById(R.id.ageAdd);
        btnAdd=findViewById(R.id.addEmplyee);

        //get Firebase

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address, name, phone,age;
                address=txtAdd.getText().toString();
                name=txtName.getText().toString();
                phone=txtPhone.getText().toString();
                age=txtAge.getText().toString();
                    new Database(getBaseContext()).addToCart(new Employee(
                            name,
                            phone,
                            address,
                            age
                    ));
                    Toast.makeText(FormAddActivity.this,"Added to Employee",Toast.LENGTH_LONG).show();
                startActivity(new Intent(FormAddActivity.this,FinishActivity.class));
            }
        });
    }




}