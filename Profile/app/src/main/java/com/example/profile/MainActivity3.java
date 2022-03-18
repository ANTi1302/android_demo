package com.example.profile;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.profile.adopter.AdopterChat;
import com.example.profile.adopter.AdopterSearch;
import com.example.profile.model.Chat;
import com.example.profile.model.Search;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    private List<Search> chatList;
    private GridView gridViewChat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        chatList= new ArrayList<>();
        gridViewChat= (GridView) findViewById(R.id.layoutParentSearch);
        chatList.add(new Search(1,"Thank you! That was very helpful!"));
        chatList.add(new Search(2,"I know... I’m trying to get the funds."));
        chatList.add(new Search(3,"I’m looking for tips around capturing the milky way. I have a 6D with a 24-100mm..."));
        chatList.add(new Search(4,"Wanted to ask if you’re available for a portrait shoot next week."));
        chatList.add(new Search(5,"Wanted to ask if you’re available for a portrait shoot next week."));
        chatList.add(new Search(6,"Wanted to ask if you’re available for a portrait shoot next week."));
        chatList.add(new Search(7,"Wanted to ask if you’re available for a portrait shoot next week."));
        chatList.add(new Search(8,"Wanted to ask if you’re available for a portrait shoot next week."));
        chatList.add(new Search(9,"Wanted to ask if you’re available for a portrait shoot next week."));
        chatList.add(new Search(10,"Wanted to ask if you’re available for a portrait shoot next week."));
        chatList.add(new Search(11,"Wanted to ask if you’re available for a portrait shoot next week."));
        chatList.add(new Search(12,"Wanted to ask if you’re available for a portrait shoot next week."));
        chatList.add(new Search(13,"Wanted to ask if you’re available for a portrait shoot next week."));
        chatList.add(new Search(14,"Wanted to ask if you’re available for a portrait shoot next week."));
        chatList.add(new Search(15,"Wanted to ask if you’re available for a portrait shoot next week."));



        AdopterSearch adopterChat= new AdopterSearch(this,R.layout.item_searchs,chatList);
        gridViewChat.setAdapter(adopterChat);
    }
}
