package com.example.myapplication.adopet;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.model.Donut;

import java.util.List;

public class Adopet extends BaseAdapter {
    private Context context;
    private int itemView;
    private List<Donut> donutList;
    private int pont=-1;
    public Adopet(Context context, int idLayout, List<Donut> donutList){
        this.context=context;
        this.itemView=idLayout;
        this.donutList=donutList;
    }
    @Override
    public int getCount() {
        if (donutList.size() !=0&& !donutList.isEmpty()){
            return donutList.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            convertView= LayoutInflater.from(parent.getContext()).inflate(itemView,parent,false);
        }
        LinearLayout linearLayout=convertView.findViewById(R.id.itemLayout);
        TextView tenSP= convertView.findViewById(R.id.tenDonut);
        TextView moTa= convertView.findViewById(R.id.moTa);
        TextView giaTien= convertView.findViewById(R.id.giaTien);
        ImageView img=convertView.findViewById(R.id.hinhanh);
        ImageButton btn=convertView.findViewById(R.id.btnCong);
        final Donut donut=donutList.get(position);
        if (donutList !=null && !donutList.isEmpty()){
            int idDonut= donut.getId();
            tenSP.setText(donut.getTenDonut());
            moTa.setText(donut.getMoTa());
            String giaTienDn= String.valueOf(donut.getGiaTien());
            giaTien.setText( giaTienDn);

            switch (idDonut){
                case 1:
                img.setImageResource(R.drawable.donut);
                btn.setImageResource(R.drawable.ic_vector);
                break;
                case 2:
                    img.setImageResource(R.drawable.donuta);
                    btn.setImageResource(R.drawable.ic_vector);
                    break;
                case 3:
                    img.setImageResource(R.drawable.donutb);
                    btn.setImageResource(R.drawable.ic_vector);
                    break;
                case 4:
                    img.setImageResource(R.drawable.donutc);
                    btn.setImageResource(R.drawable.ic_vector);
                    break;
                default:
                    break;

            }
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, donut.getTenDonut(), Toast.LENGTH_LONG).show();
                pont=position;
                notifyDataSetChanged();
            }
        });
    if (pont== position){
        linearLayout.setBackgroundColor(Color.BLUE);
    }else {
        linearLayout.setBackgroundColor(Color.GRAY);
    }

        return convertView;
    }
}
