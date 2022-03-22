package com.example.fragment_demo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class DetailsFragment extends Fragment {
    TextView name,phone;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.details_view, container, false);
        name = (TextView)view.findViewById(R.id.Name);
        phone = (TextView)view.findViewById(R.id.Phone);
        return view;
    }
    public void change(String uname, String ulocation){
        name.setText(uname);
        phone.setText(ulocation);
    }
}