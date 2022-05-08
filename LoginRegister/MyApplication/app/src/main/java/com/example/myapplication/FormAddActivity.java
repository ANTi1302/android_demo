package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.entity.Employee;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormAddActivity extends AppCompatActivity {
    private String employeeId;
    private Employee employee;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private TextView txtName,txtPhone,txtAdd,txtAge;
    private Button btnAdd;
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
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        mDatabase=database.getInstance().getReference().child("Employee");
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address, name, phone,age;
                address=txtAdd.getText().toString();
                name=txtName.getText().toString();
                phone=txtPhone.getText().toString();
                age=txtAge.getText().toString();
                
                if (TextUtils.isEmpty(employeeId)) {
                    createUser(name, phone,address,age);
                } else {
                    updateUser(name, phone,address,age);
                }
            }
        });
    }


    private void createUser(String name, String phone, String address, String age) {
        if (TextUtils.isEmpty(employeeId)) {
            employeeId = mDatabase.push().getKey();
        }

        employee = new Employee(name,phone,address,age);

        mDatabase.child(employeeId).setValue(employee);


    }
    private void updateUser(String name, String phone, String address, String age) {
    }

}