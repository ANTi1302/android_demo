package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.entity.Employee;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.NumberFormat;
import java.util.Locale;

public class FormUploadActivity extends AppCompatActivity {
    TextView txtName,txtPhone,txtAddress,txtAge;
    Button btnUpload,btnDelete;
    private String empId="";

    private FirebaseDatabase database;
    private DatabaseReference employee;
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
        database= FirebaseDatabase.getInstance();
        employee=database.getReference("Employee");
        //Get intent here
        if (getIntent()!=null){
            empId=getIntent().getStringExtra("EmployeeId");


        }if (!empId.isEmpty()&&empId!=null){
            loadListEmpDetail(empId);
        }

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               final Employee empl = new Employee();
                empl.setName(txtName.getText().toString());
                empl.setAge(txtAge.getText().toString());
                empl.setAddress(txtAddress.getText().toString());
                empl.setPhone(txtPhone.getText().toString());
                employee.child(empId).setValue(empl);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                employee.child(empId).removeValue();

            }
        });

    }

    private void loadListEmpDetail(String empId) {
        employee.child(empId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                currentemp=snapshot.getValue(Employee.class);

                //Set Image
//                Picasso.with(getBaseContext()).load(currentfood.getImage()).into(imgFood);
                if (currentemp==null|| currentemp.getName().isEmpty()||currentemp.getAddress().isEmpty()||currentemp.getPhone().isEmpty()||currentemp.getAge().isEmpty()){
                    Intent intent=new Intent(FormUploadActivity.this,FinishActivity.class);
                    startActivity(intent);
                }else {
                    txtName.setText(currentemp.getName());
                    txtAddress.setText(currentemp.getAddress());
                    txtPhone.setText(currentemp.getPhone());
                    txtAge.setText(currentemp.getAge());
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });
    }
}