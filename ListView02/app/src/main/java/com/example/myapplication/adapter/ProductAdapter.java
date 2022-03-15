package com.example.myapplication.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.myapplication.R;
import com.example.myapplication.model.Language;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private int idListView;
    private List<Language> listLanguage;
    private int positionSelect = -1;

    public ProductAdapter(Context context, int idListView, List<Language> listLanguage) {
        this.context = context;
        this.idListView = idListView;
        this.listLanguage = listLanguage;
    }

    @Override
    public int getCount() {
        if (listLanguage.size() != 0 && !listLanguage.isEmpty()) {
            return listLanguage.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            //layout con
            convertView = LayoutInflater.from(parent.getContext()).inflate(idListView, parent, false);
        }

//        TextView ten1 = convertView.findViewById(R.id.tensanpham2);
        TextView ten = (TextView)convertView.findViewById(R.id.tensanpham);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.logo);
//        ImageView imageView1 = (ImageView) convertView.findViewById(R.id.logo2);
        TextView giaTien = (TextView) convertView.findViewById(R.id.giaTien);
//        TextView giaTien1 = (TextView) convertView.findViewById(R.id.giaTien2);
        TextView danhGia = (TextView) convertView.findViewById(R.id.danhGia);
//        TextView danhGia1 = (TextView) convertView.findViewById(R.id.danhGia2);
        final  ImageView linearLayout = (ImageView) convertView.findViewById(R.id.logo);
//        final ImageView linearLayout1 = (ImageView) convertView.findViewById(R.id.logo2);
        final Language language = listLanguage.get(position);

        if (listLanguage != null && !listLanguage.isEmpty()) {
            ten.setText(language.getName());
//            ten1.setText(language.getName());
            String languageGiaTien= String.valueOf((float) language.getGiaTien());
            giaTien.setText(languageGiaTien);
//            giaTien1.setText(languageGiaTien);
            String languageDanhGia= String.valueOf((int) language.getDanhGia());
            danhGia.setText(languageDanhGia);
//            danhGia1.setText(languageDanhGia);
            int idLanguage = language.getId();
            switch (idLanguage) {
                case 1:
                    imageView.setImageResource(R.drawable.dauchuyendoipsps);
//                    imageView1.setImageResource(R.drawable.carbusbtops);

                    break;
                case 2:
                    imageView.setImageResource(R.drawable.dauchuyendoi);
//                    imageView1.setImageResource(R.drawable.giacchuyen);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.dauchuyendoipsps);
//                    imageView1.setImageResource(R.drawable.daucam);
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.daynguon);
//                    imageView1.setImageResource(R.drawable.carbusbtops);
                    break;
                case 5:
                    imageView.setImageResource(R.drawable.dauchuyendoi);
//                    imageView1.setImageResource(R.drawable.dauchuyendoipsps);
                    break;
                case 6:
                    imageView.setImageResource(R.drawable.giacchuyen);
//                    imageView1.setImageResource(R.drawable.daynguon);
                    break;
                case 7:
                    imageView.setImageResource(R.drawable.carbusbtops);
//                    imageView1.setImageResource(R.drawable.daucam);
                    break;
                case 8:
                    imageView.setImageResource(R.drawable.dauchuyendoi);
//                    imageView1.setImageResource(R.drawable.daynguon);
                    break;
                default:
                    break;
            }
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, language.getName(), Toast.LENGTH_LONG).show();
                positionSelect = position;
                notifyDataSetChanged();
            }
        });

        if (positionSelect == position) {
            linearLayout.setBackgroundColor(Color.GRAY);
//            linearLayout1.setBackgroundColor(Color.GRAY);
        } else {
            linearLayout.setBackgroundColor(Color.WHITE);
//            linearLayout1.setBackgroundColor(Color.WHITE);
        }
        return convertView;
    }

}