package com.example.profile.adopter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.profile.MainActivity2;
import com.example.profile.MainActivity3;
import com.example.profile.R;
import com.example.profile.model.Chat;
import com.example.profile.model.Search;

import java.util.List;

public class AdopterChat extends BaseAdapter {
    private Context context;
    private List<Chat> chatList;
    private int pointAt=-1;
    private int point;
    public AdopterChat(Context context, int point, List<Chat> chatList){
        this.context=context;
        this.point=point;
        this.chatList=chatList;
    }
    @Override
    public int getCount() {
        if (chatList.size()!=0&&!chatList.isEmpty()){
            return chatList.size();
        }return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            view= LayoutInflater.from(viewGroup.getContext()).inflate(point,viewGroup,false);
        }
        TextView textView=view.findViewById(R.id.ten);
        TextView textView1=view.findViewById(R.id.moTa);
        ImageView imageView=view.findViewById(R.id.imageView);
        Chat chat=chatList.get(i);
        if (chatList.size()!=0&&!chatList.isEmpty()){
            textView.setText(chat.getTen());
            textView1.setText(chat.getMoTa());
            int id=chat.getId();
            switch (id){
                case 1:
                    imageView.setImageResource(R.drawable.ava1);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.ava2);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.ava3);
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.ava4);
                    break;
                default:
                    break;
            }
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idDonut= chat.getId();
                Toast.makeText(context, chat.getTen(), Toast.LENGTH_LONG).show();
                point=pointAt;
                Intent intent= new Intent();
                intent = intent.setClass(context,
                        MainActivity3.class);
                String ten=textView.getText().toString();
                intent.putExtra("ten",ten);
                context.startActivity(intent);
                notifyDataSetChanged();

            }
        });
        return view;


    }
}
