package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.adopet.Adopet;
import com.example.myapplication.model.Donut;

import java.util.ArrayList;
import java.util.List;

import static com.example.myapplication.R.id.itemLayout;

public class MainActivity extends AppCompatActivity {

    private List<Donut> donutList;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= (ListView) findViewById(R.id.listView);
        donutList= new ArrayList<>();
        donutList.add(new Donut(1,"Donut","good",25));
        donutList.add(new Donut(2,"Donut","good",25));
        donutList.add(new Donut(3,"Donut","good",25));
        donutList.add(new Donut(4,"Donut","good",25));
        donutList.add(new Donut(5,"Donut","good",25));
        donutList.add(new Donut(6,"Donut","good",25));

        Adopet adopet= new Adopet(this,R.layout.item_layout, donutList);
        listView.setAdapter(adopet);


    }
}