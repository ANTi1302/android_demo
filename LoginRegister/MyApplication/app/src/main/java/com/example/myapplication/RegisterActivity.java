package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Common.Common;
import com.example.myapplication.entity.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    private FirebaseAuth mAuth;
    private TextView yourName,email,ageText,password;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //set keyId
        yourName=findViewById(R.id.editTextTextPersonName4);
        email=findViewById(R.id.editTextTextPersonName);
        ageText=findViewById(R.id.editTextTextPersonName3);
        password=findViewById(R.id.editTextTextPersonName2);
        btnRegister=findViewById(R.id.button3);

        //Ket noi FireBase
        mAuth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button3:
                registerUser();
                break;
        }
    }

    private void registerUser() {
        String name=yourName.getText().toString().trim();
        String mail=email.getText().toString().trim();
        String age=ageText.getText().toString().trim();
        String pass=password.getText().toString().trim();
        if (name.isEmpty()){
            yourName.setError("Not null nghe hong");
            yourName.requestFocus();
            return;
        }

        if (mail.isEmpty()){
            email.setError("Not null nghe hong");
            email.requestFocus();
            return;
        }

        if (age.isEmpty()){
            ageText.setError("Not null nghe hong");
            ageText.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
            email.setError("Please dung mail dummm!");
            email.requestFocus();
            return;
        }
        if (pass.isEmpty()){
            password.setError("Not null nghe hong");
            password.requestFocus();
            return;
        }
        if (pass.length()<6){
            password.setError("Dai ty diiii");
            password.requestFocus();
            return;
        }

        //Tao user ben Auth
        mAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            //Tao doi tuong user
                            User user= new User(name,age,mail,pass);
                            //Dong thoi tao user ben firebase
                            FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()){
                                        //Chuyen trang dong thoi truyen du lieu user
                                        Toast.makeText(RegisterActivity.this,"User has been",Toast.LENGTH_LONG).show();
                                        Common.currentUser=user;
                                        Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                                        startActivity(intent);

                                    }else {
                                        Toast.makeText(RegisterActivity.this,"Failed has been",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });
                        }
                        else {
                            Toast.makeText(RegisterActivity.this,"Failed has been",Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
