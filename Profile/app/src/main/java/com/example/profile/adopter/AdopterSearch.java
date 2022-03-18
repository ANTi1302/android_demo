package com.example.profile.adopter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.profile.R;
import com.example.profile.model.Search;

import java.util.List;

public class AdopterSearch extends BaseAdapter {
    private Context context;
    private int point;
    private List<Search> searchList;
    private int pontAt=-1;
    public AdopterSearch(Context context,int point,List<Search> searchList){
        this.context=context;
        this.point=point;
        this.searchList=searchList;
    }
    @Override
    public int getCount() {
       if (searchList.size()!=0&&!searchList.isEmpty()){
           return searchList.size();
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
        if (view==null){
            view= LayoutInflater.from(viewGroup.getContext()).inflate(point,viewGroup,false);
        }
        ImageView imageView=view.findViewById(R.id.anh);
        Search search=searchList.get(i);
        if (searchList.size()!=0&&!searchList.isEmpty())
        {
            int id=search.getId();
            switch (id){
                case 1:
                    imageView.setImageResource(R.drawable.cho01);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.cho02);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.cho03);
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.cho4);
                    break;
                case 5:
                    imageView.setImageResource(R.drawable.cho5);
                    break;
                case 6:
                    imageView.setImageResource(R.drawable.cho6);
                    break;
                case 7:
                    imageView.setImageResource(R.drawable.cho7);
                    break;
                case 8:
                    imageView.setImageResource(R.drawable.cho8);
                    break;
                case 9:
                    imageView.setImageResource(R.drawable.cho9);
                    break;
                case 10:
                    imageView.setImageResource(R.drawable.cho10);
                    break;
                case 11:
                    imageView.setImageResource(R.drawable.cho11);
                    break;
                case 12:
                    imageView.setImageResource(R.drawable.cho12);
                    break;
                case 13:
                    imageView.setImageResource(R.drawable.cho13);
                    break;
                case 14:
                    imageView.setImageResource(R.drawable.cho14);
                    break;
                case 15:
                    imageView.setImageResource(R.drawable.cho15);
                    break;
                default:
                    break;
            }
        }
        return view;
    }
}
