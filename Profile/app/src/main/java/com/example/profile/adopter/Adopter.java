package com.example.profile.adopter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.profile.R;
import com.example.profile.model.Picture;

import java.util.List;

public class Adopter extends BaseAdapter {

    private Context context;
    private int point;
    private List<Picture> pictureList;
    private int pointAt=-1;
    public Adopter(Context context, int point, List<Picture> pictureList){
        this.context=context;
        this.point=point;
        this.pictureList=pictureList;
    }
    @Override
    public int getCount() {
        if (pictureList.size()!= 0&&!pictureList.isEmpty()){
            return pictureList.size();
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
        if (viewGroup!=null){
            view= LayoutInflater.from(viewGroup.getContext()).inflate(point,viewGroup,false);
        }
        ConstraintLayout constraintLayout=view.findViewById(R.id.layoutitem);
        ImageView imageView=view.findViewById(R.id.imageView3);
        Picture picture=pictureList.get(i);
        if (pictureList!=null&&!pictureList.isEmpty()){
            int idPic= picture.getId();
            switch (idPic){
                case 1:
                    imageView.setImageResource(R.drawable.hinh1);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.hinh2);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.hinh3);
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.hinh4);
                    break;
                case 5:
                    imageView.setImageResource(R.drawable.hinh5);
                    break;
                case 6:
                    imageView.setImageResource(R.drawable.hinh6);
                    break;
                default:
                    break;
            }
        }


        return view;
    }
}
