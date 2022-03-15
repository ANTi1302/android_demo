package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_layout2);

        TextView textView=findViewById(R.id.tenSP);
        TextView textView1=findViewById(R.id.moTa);
        TextView textView2=findViewById(R.id.tenSP);
        TextView textView3=findViewById(R.id.giaTien);
        ImageView img=findViewById(R.id.hinhAnh);
        Intent i=getIntent();
        String duLieuTenSp=i.getStringExtra("duLieuTenSp");
        String dulieumoTa=i.getStringExtra("duLieuMota");
        String dulieuImg=i.getStringExtra("duLieuHinhAnh");
        String dulieuGia=i.getStringExtra("duLieuGiaSp");
        switch (dulieuImg){
            case "1":
                img.setImageResource(R.drawable.donut);

                break;
            case "2":
                img.setImageResource(R.drawable.donuta);

                break;
            case "3":
                img.setImageResource(R.drawable.donutb);

                break;
            case "4":
                img.setImageResource(R.drawable.donutc);

                break;
            case "5":
                img.setImageResource(R.drawable.donuta);

                break;
            case "6":
                img.setImageResource(R.drawable.donutc);

                break;
            case "7":
                img.setImageResource(R.drawable.donutb);

                break;
            case "8":
                img.setImageResource(R.drawable.donut);

                break;
            default:
                break;
        }

        textView.setText(duLieuTenSp);
        textView1.setText(dulieumoTa);
        textView3.setText(dulieuGia);

    }

}
