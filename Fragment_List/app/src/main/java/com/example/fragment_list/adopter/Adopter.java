package com.example.fragment_list.adopter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fragment_list.FragmentDetails;
import com.example.fragment_list.Fragment_List;
import com.example.fragment_list.MainActivity2;
import com.example.fragment_list.R;
import com.example.fragment_list.product.Product;

import java.util.List;

public class Adopter extends BaseAdapter {
    private Context context;
    private int idListView;
    private List<Product> listProduct;
    private int positionSelect = -1;
    public Adopter(Context context, int idListView, List<Product> listProduct) {
        this.context = context;
        this.idListView = idListView;
        this.listProduct = listProduct;
    }
    @Override
    public int getCount() {
        if (listProduct.size() != 0 && !listProduct.isEmpty()) {
            return listProduct.size();
        }
        return 0;
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
        if (view == null) {
            //layout con
            view = LayoutInflater.from(viewGroup.getContext()).inflate(idListView, viewGroup, false);
        }

        TextView ten = (TextView)view.findViewById(R.id.content);
        ImageView imageView = (ImageView) view.findViewById(R.id.image);

        final Product product = listProduct.get(i);

        if (listProduct != null && !listProduct.isEmpty()) {
            ten.setText(product.getTen());

            int idLanguage = product.getId();
            switch (idLanguage) {
                case 1:
                    imageView.setImageResource(R.drawable.a);
//                    imageView1.setImageResource(R.drawable.carbusbtops);

                    break;
                case 2:
                    imageView.setImageResource(R.drawable.b);
//                    imageView1.setImageResource(R.drawable.giacchuyen);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.c);
//                    imageView1.setImageResource(R.drawable.daucam);
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.d);
//                    imageView1.setImageResource(R.drawable.carbusbtops);
                    break;
                case 5:
                    imageView.setImageResource(R.drawable.e);
//                    imageView1.setImageResource(R.drawable.dauchuyendoipsps);
                    break;
                case 6:
                    imageView.setImageResource(R.drawable.f);
//                    imageView1.setImageResource(R.drawable.daynguon);
                    break;
                case 7:
                    imageView.setImageResource(R.drawable.g);
//                    imageView1.setImageResource(R.drawable.daucam);
                    break;
                case 8:
                    imageView.setImageResource(R.drawable.a);
//                    imageView1.setImageResource(R.drawable.daynguon);
                    break;
                default:
                    break;
            }
        }
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id= product.getId();
                Toast.makeText(context, product.getTen(), Toast.LENGTH_LONG).show();
                positionSelect = i;
                Intent intent= new Intent();
                intent = intent.setClass(context,
                        MainActivity2.class);

                //Truyen du lieu


                String s1= ten.getText().toString();

                String s4= String.valueOf(id);
                intent.putExtra("duLieuTenSp",s1);

                intent.putExtra("duLieuHinhAnh",s4);

                context.startActivity(intent);


                notifyDataSetChanged();
            }
        });


        return view;

    }
}
