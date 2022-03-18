package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.myapplication.adopet.Adopet;
import com.example.myapplication.model.Donut;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.example.myapplication.R.id.itemLayout;

public class MainActivity extends AppCompatActivity {

    private List<Donut> donutList;
    private List<Donut> donutListSearch;
    private List<Donut> donutListSearchBt;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donutListSearch= new ArrayList<>();
        donutListSearchBt=new ArrayList<>();
        listView= (ListView) findViewById(R.id.listView);
        listView.setDivider(null);
        donutList= new ArrayList<>();
        donutList.add(new Donut(1,"Donut A","good",25));
        donutList.add(new Donut(2,"Donut B","good",35));
        donutList.add(new Donut(3,"Donut C","good",25));
        donutList.add(new Donut(4,"Donut D","good",26));
        donutList.add(new Donut(5,"Donut E","good",55));
        donutList.add(new Donut(6,"Donut F","good",98));

        Adopet adopet= new Adopet(this,R.layout.item_layout, donutList);
        listView.setAdapter(adopet);

        TextInputEditText textInputEditText= findViewById(R.id.timKiem);
        TextInputLayout textInputLayout= findViewById(R.id.btnTimKiem);
        Button button=findViewById(R.id.button2);
        button.setText("Donut A");
        Button button1=findViewById(R.id.button1);
        button1.setText("Donut");
        Button button3=findViewById(R.id.button3);


    textInputLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            donutListSearch.clear();

                for (Donut donut : donutList) {
                    String temp = textInputEditText.getText().toString().toLowerCase().trim();

                    if (donut.getTenDonut().toString().toLowerCase().trim().contains(temp)) {

                        donutListSearch.add(donut);
                    }

                  
                }

                listView.setAdapter(new Adopet(MainActivity.this, R.layout.item_layout, donutListSearch));
            }



//



    });

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            donutListSearchBt.clear();
            for (Donut donut : donutList) {

            String btn=button.getText().toString().toLowerCase().trim();
                if (donut.getTenDonut().toString().toLowerCase().trim().contains(btn)) {

                    donutListSearchBt.add(donut);
                }


            }

            listView.setAdapter(new Adopet(MainActivity.this, R.layout.item_layout, donutListSearchBt));

        }
    });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

donutListSearchBt.clear();
                for (Donut donut : donutList) {

                    String btn=button1.getText().toString().toLowerCase().trim();
                    if (donut.getTenDonut().toString().toLowerCase().trim().contains(btn)) {

                        donutListSearchBt.add(donut);
                    }


                }

                listView.setAdapter(new Adopet(MainActivity.this, R.layout.item_layout, donutListSearchBt));

            }
        });

}



}