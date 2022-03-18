package com.example.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import com.example.profile.adopter.Adopter;
import com.example.profile.adopter.AdopterChat;
import com.example.profile.model.Chat;
import com.example.profile.model.Picture;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Picture> pictureList;

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gridView= (GridView) findViewById(R.id.layoutParent);

//        gridView.setDivider(null);
        pictureList= new ArrayList<>();
        pictureList.add(new Picture(1,""));
        pictureList.add(new Picture(2,""));
        pictureList.add(new Picture(3,""));
        pictureList.add(new Picture(4,""));
        pictureList.add(new Picture(5,""));
        pictureList.add(new Picture(6,""));


        Adopter adopet= new Adopter(this,R.layout.item, pictureList);

        gridView.setAdapter(adopet);
        Button button=findViewById(R.id.massage);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent();
                intent = intent.setClass(MainActivity.this,
                        MainActivity2.class);
                startActivity(intent);
            }
        });



    }
}