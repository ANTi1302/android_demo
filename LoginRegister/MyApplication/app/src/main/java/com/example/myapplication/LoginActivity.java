package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.entity.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private String email,password;
    private TextView user,pass;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        user=findViewById(R.id.editTextTextPersonName);
        pass=findViewById(R.id.editTextTextPersonName2);
        btnLogin=findViewById(R.id.button2);
         btnLogin.setOnClickListener(this);
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button2:
                userLogin();
                break;
        }
    }

    private void userLogin() {
        email=user.getText().toString().trim();
        password=pass.getText().toString().trim();

        if (email.isEmpty()){
            user.setError("Email is required");
            user.requestFocus();
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            user.setError("Please dung mail dummm!");
            user.requestFocus();
            return;
        }
        if (password.isEmpty()){
            pass.setError("Pass is required");
            pass.requestFocus();
        }
        if (password.length()<6){
            pass.setError("Dai ty diiii");
            pass.requestFocus();
            return;
        }

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(LoginActivity.this,FinishActivity.class));
                }
                else {
                    Toast.makeText(LoginActivity.this,"Failed has been",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}