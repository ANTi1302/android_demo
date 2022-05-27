package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DB.Database;
import com.example.myapplication.HolderViewItem.CartAdapter;
import com.example.myapplication.entity.Employee;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class FinishActivity extends AppCompatActivity {

   private TextView txtFinish;
    private List<Employee> carts=new ArrayList<>();
    private RecyclerView.LayoutManager gridLayoutManager;
    private ImageButton btnAdd, btnDelete,btnUpload;
    private CartAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //set keyId
        txtFinish=findViewById(R.id.textView2);



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
                new Database(getBaseContext()).deleteToCart();
                Toast.makeText(FinishActivity.this,"Xóa employee thành công",Toast.LENGTH_SHORT).show();
                loadListFood();
            }
        });
        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //Init Firebase


        //Load employee
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        loadListFood();


    }
    private void loadListFood() {

        carts=new Database(this).getCart();
        adapter= new CartAdapter(carts,this);
        recyclerView.setAdapter(adapter);



    }

}