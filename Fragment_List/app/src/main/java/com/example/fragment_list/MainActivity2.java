package com.example.fragment_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    ImageView img;
    TextView ten,moTa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textView=findViewById(R.id.textView);
        TextView textView1=findViewById(R.id.textView2);
        ImageView img=findViewById(R.id.imageView);
        Intent i=getIntent();
        String duLieuTenSp=i.getStringExtra("duLieuTenSp");
        String dulieuImg=i.getStringExtra("duLieuHinhAnh");
        switch (dulieuImg){
            case "1":
                img.setImageResource(R.drawable.a);

                break;
            case "2":
                img.setImageResource(R.drawable.b);

                break;
            case "3":
                img.setImageResource(R.drawable.c);

                break;
            case "4":
                img.setImageResource(R.drawable.d);

                break;
            case "5":
                img.setImageResource(R.drawable.e);

                break;
            case "6":
                img.setImageResource(R.drawable.f);

                break;
            case "7":
                img.setImageResource(R.drawable.g);

                break;
            case "8":
                img.setImageResource(R.drawable.a);

                break;
            default:
                break;
        }

        textView.setText(duLieuTenSp);



    }
}