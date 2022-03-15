package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;


import com.example.myapplication.adapter.ProductAdapter;
import com.example.myapplication.model.Language;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Language> languageList,languageList1;
    private GridView listView,listView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_list_view_activity);

        listView= (GridView) findViewById(R.id.idListView);
//        listView1= (GridView) findViewById(R.id.idListView01);
        languageList = new ArrayList<>();
        languageList.add(new Language(1, 65,"A",1));
        languageList.add(new Language(2, 65,"B",5));
        languageList.add(new Language(3, 65,"C",2));
        languageList.add(new Language(4, 65,"D",15));
        languageList.add(new Language(5, 65,"E",25));
        languageList.add(new Language(6, 65,"F",10));
        languageList.add(new Language(7, 65,"K",11));
        languageList.add(new Language(8, 65,"M",25));

        languageList1 = new ArrayList<>();
        languageList1.add(new Language(1, 65,"A",1));
        languageList1.add(new Language(2, 65,"B",5));
        languageList1.add(new Language(3, 65,"C",2));
        languageList1.add(new Language(4, 65,"D",15));
        languageList1.add(new Language(5, 65,"E",25));
        languageList1.add(new Language(6, 65,"F",10));
        languageList1.add(new Language(7, 65,"K",11));
        languageList1.add(new Language(8, 65,"M",25));

        ProductAdapter adapter = new ProductAdapter(this, R.layout.layout_items, languageList);
//        ProductAdapter adapter1 = new ProductAdapter(this, R.layout.layout_items, languageList1);
        listView.setAdapter(adapter);
//        listView1.setAdapter(adapter1);
    }
}