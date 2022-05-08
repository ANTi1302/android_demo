package com.example.myapplication.HolderItemView;

import android.view.View;
import android.widget.TextView;


import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Interface.ItemViewHolder;
import com.example.myapplication.R;

public class EmployeeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txtName,txtAdrress,txtPhone,txtAge;
    private ItemViewHolder itemViewHolder;
    public EmployeeHolder( View itemView) {
        super(itemView);
        txtName=itemView.findViewById(R.id.txtName);
        txtAdrress=itemView.findViewById(R.id.txtAdress);
        txtPhone=itemView.findViewById(R.id.txtPhone);
        txtAge=itemView.findViewById(R.id.txtAge);

        itemView.setOnClickListener(this);
    }

    public void setItemViewHolder(ItemViewHolder itemViewHolder) {
        this.itemViewHolder = itemViewHolder;
    }

    @Override
    public void onClick(View view) {
    itemViewHolder.OnClick(view,getAdapterPosition(),false);
    }
}
