package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.myapplication.adopet.Adopet;
import com.example.myapplication.model.Donut;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import static com.example.myapplication.R.id.itemLayout;

public class MainActivity extends AppCompatActivity {

    private List<Donut> donutList;
    private List<Donut> donutListSearch;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donutListSearch= new ArrayList<>();
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



    textInputLayout.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int count=0;
            for (Donut donut : donutList) {
                String temp = textInputEditText.getText().toString();
                if (donut.getTenDonut().toString().contains(temp)) {
                    donutListSearch.add(donut);

                }

            }
            listView.setAdapter(new Adopet(MainActivity.this, R.layout.item_layout, donutListSearch));




        }
    });

}


}