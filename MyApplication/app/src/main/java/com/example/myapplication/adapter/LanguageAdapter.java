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

public class LanguageAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Language> listLanguage;
    private int positionSelect = -1;

    public LanguageAdapter(Context context, int idLayout, List<Language> listLanguage) {
        this.context = context;
        this.idLayout = idLayout;
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
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
        }

        TextView tvLanguageName = (TextView) convertView.findViewById(R.id.tvLanguageName);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.logo);
        TextView tvGiaTien = (TextView) convertView.findViewById(R.id.giaTien);
        final LinearLayout linearLayout = (LinearLayout) convertView.findViewById(R.id.idLinearLayout);
        final Language language = listLanguage.get(position);

        if (listLanguage != null && !listLanguage.isEmpty()) {
            tvLanguageName.setText(language.getName());
           String languageGiaTien= String.valueOf((float) language.getGiaTien());
            tvGiaTien.setText(languageGiaTien);
            int idLanguage = language.getId();
            switch (idLanguage) {
                case 1:
                    imageView.setImageResource(R.drawable.carbusbtops);

                    break;
                case 2:
                    imageView.setImageResource(R.drawable.daucam);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.dauchuyendoi);
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.dauchuyendoipsps);
                    break;
                case 5:
                    imageView.setImageResource(R.drawable.daynguon);
                    break;
                case 6:
                    imageView.setImageResource(R.drawable.giacchuyen);
                    break;
                case 7:
                    imageView.setImageResource(R.drawable.dauchuyendoipsps);
                    break;
                case 8:
                    imageView.setImageResource(R.drawable.carbusbtops);
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
        } else {
            linearLayout.setBackgroundColor(Color.WHITE);
        }
        return convertView;
    }

}