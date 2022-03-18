package com.example.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.profile.adopter.AdopterChat;
import com.example.profile.model.Chat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private List<Chat> chatList;
    private ListView gridViewChat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
        chatList= new ArrayList<>();
        gridViewChat= (ListView) findViewById(R.id.layoutParentChat);
        chatList.add(new Chat(1,"James","Thank you! That was very helpful!"));
        chatList.add(new Chat(2,"Will Kenny","I know... I’m trying to get the funds."));
        chatList.add(new Chat(3,"Beth Williams","I’m looking for tips around capturing the milky way. I have a 6D with a 24-100mm..."));
        chatList.add(new Chat(4,"Rev Shawn","Wanted to ask if you’re available for a portrait shoot next week."));
        AdopterChat adopterChat= new AdopterChat(this,R.layout.item_chats,chatList);
        gridViewChat.setAdapter(adopterChat);

//        gridViewChat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent= new Intent();
//                intent = intent.setClass(MainActivity2.this,
//                        MainActivity3.class);
//                startActivity(intent);
//            }
//        });
    }
}
