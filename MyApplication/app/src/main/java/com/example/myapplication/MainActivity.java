package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.myapplication.adapter.LanguageAdapter;
import com.example.myapplication.model.Language;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Language> listLanguage;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_list_view_activity);

        listView = (ListView) findViewById(R.id.idListView);
        listLanguage = new ArrayList<>();
        listLanguage.add(new Language(1, 65,"Lập Trình Java"));
        listLanguage.add(new Language(2, 65,"Lập Trình Android"));
        listLanguage.add(new Language(3, 65,"Lập Trình JavaFX"));
        listLanguage.add(new Language(4, 65,"Lập Trình Web"));
        listLanguage.add(new Language(5, 65,"Lập Trình Ruby"));
        listLanguage.add(new Language(6, 65,"Lập Trình C++"));
        listLanguage.add(new Language(7, 65,"Lập Trình PHP"));
        listLanguage.add(new Language(8, 65,"Lập Trình WordPress"));

        LanguageAdapter adapter = new LanguageAdapter(this, R.layout.item_custom_list_view, listLanguage);
        listView.setAdapter(adapter);

    }
}