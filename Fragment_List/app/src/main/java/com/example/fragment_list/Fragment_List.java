package com.example.fragment_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.example.fragment_list.adopter.Adopter;
import com.example.fragment_list.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Fragment_List extends ListFragment {
    private List<Product> productList;
    private ListView listView;
    Fragment_List frg_list;
    FragmentDetails frg_b;
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_item_list, container, false);
        listView=(ListView) view.findViewById(R.id.list);

        productList = new ArrayList<>();
        productList.add(new Product(1,"A","","Pls touch to see detail",1));
        productList.add(new Product(2,"A","","Pls touch to see detail",1));
        productList.add(new Product(3,"A","","Pls touch to see detail",1));
        productList.add(new Product(4,"A","","Pls touch to see detail",1));
        productList.add(new Product(5,"A","","Pls touch to see detail",1));
        productList.add(new Product(6,"A","","Pls touch to see detail",1));
        productList.add(new Product(7,"A","","Pls touch to see detail",1));
        productList.add(new Product(8,"A","","Pls touch to see detail",1));

        Adopter adapter = new Adopter(getActivity(), R.layout.fragment_item, productList);

       listView.setAdapter(adapter);
        frg_list= new Fragment_List();
        frg_b= new FragmentDetails();
//        textView=view.findViewById(R.id.content);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getActivity(), "aaaaaaa", Toast.LENGTH_LONG).show();
//
//            }
//        });
        return view;
    }

//    @Override
//    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
//        FragmentDetails txt = (FragmentDetails) getFragmentManager().findFragmentById(R.id.fragment2);
//        super.onListItemClick(l, v, position, id);
//    }
}
