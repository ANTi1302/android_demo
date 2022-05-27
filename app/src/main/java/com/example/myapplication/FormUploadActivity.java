package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.DB.Database;
import com.example.myapplication.HolderViewItem.CartAdapter;
import com.example.myapplication.entity.Employee;

import java.util.List;

public class FormUploadActivity extends AppCompatActivity {
    TextView txtName,txtPhone,txtAddress,txtAge;
    Button btnUpload,btnDelete;
    private String empName="";
    private String empPhone="";
    private String empAdd="";
    private String empAge="";
    private String empId="";
    int a=0;

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
            empName=getIntent().getStringExtra("EmployeeName");
            empPhone=getIntent().getStringExtra("EmployeePhone");
            empAdd=getIntent().getStringExtra("EmployeeAdd");
            empAge=getIntent().getStringExtra("EmployeeAge");
            empId=getIntent().getStringExtra("EmployeeId");
            a=Integer.parseInt(empId);

        }if (!empName.isEmpty()&&empName!=null||!empPhone.isEmpty()&&empPhone!=null||!empAdd.isEmpty()&&empAdd!=null||!empAge.isEmpty()&&empAge!=null){
            loadListEmpDetail(empName,empPhone,empAdd,empAge);
        }

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee employeeup=new Employee();
                employeeup.setEmployeeId( a);
                employeeup.setName(  txtName.getText().toString());
                employeeup.setPhone(  txtPhone.getText().toString());
                employeeup.setAddress(  txtAddress.getText().toString());
                employeeup.setAge(  txtAge.getText().toString());
                new Database(getBaseContext()).updateUse(employeeup);

                Toast.makeText(FormUploadActivity.this,"Update to Employee",Toast.LENGTH_LONG).show();
                startActivity(new Intent(FormUploadActivity.this,FinishActivity.class));
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Database(getBaseContext()).deleteUser(a);

                Toast.makeText(FormUploadActivity.this,"Delete to Employee",Toast.LENGTH_LONG).show();
                startActivity(new Intent(FormUploadActivity.this,FinishActivity.class));


            }
        });

    }

    private void loadListEmpDetail(String empName, String empPhone, String empAdd, String empAge) {

//        new Database(getBaseContext()).getCartByAll(empPhone);
        Employee carts = new Database(this).getCartByAll(a);
        txtName.setText(carts.getName());
        txtAddress.setText(carts.getAddress());
        txtPhone.setText(carts.getPhone());
        txtAge.setText(carts.getAge());
    }


}