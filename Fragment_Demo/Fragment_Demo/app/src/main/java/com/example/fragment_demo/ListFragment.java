package com.example.fragment_demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ListFragment extends android.app.ListFragment {
    String[] users = new String[] { "Thư","Lâm","Mẹeee","Buuuu","Hạnh","Ngân" };
    String[] phone = new String[]{"0932904529","No phone","0788517086","0907408575","0388517086","No phone"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.listitems_view, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, users);
        setListAdapter(adapter);
        return view;
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        DetailsFragment txt = (DetailsFragment) getFragmentManager().findFragmentById(R.id.fragment2);
        txt.change("Name: "+ users[position],"Phone : "+ phone[position]);
        getListView().setSelector(android.R.color.darker_gray);
    }
}
