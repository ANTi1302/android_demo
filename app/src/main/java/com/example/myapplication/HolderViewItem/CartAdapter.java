package com.example.myapplication.HolderViewItem;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.FinishActivity;
import com.example.myapplication.FormUploadActivity;
import com.example.myapplication.Interface.ItemClickListen;
import com.example.myapplication.R;
import com.example.myapplication.entity.Employee;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView txtName,txtPhone,txtAdd,txtAge;
    private ItemClickListen itemClickListen;
    public CartViewHolder(View itemView) {
        super(itemView);
        txtName=itemView.findViewById(R.id.txtNameView);
        txtPhone=itemView.findViewById(R.id.txtPhone);
        txtAdd=itemView.findViewById(R.id.txtAdress);
        txtAge=itemView.findViewById(R.id.txtAge);

        itemView.setOnClickListener(this);
    }

    public void setTxtCartName(TextView txtName) {
        this.txtName = txtName;
    }

    @Override
    public void onClick(View view) {
       Toast.makeText(itemView.getContext(), "Da chon "+txtName.getText().toString(),Toast.LENGTH_LONG).show();
        Intent foodList=new Intent(itemView.getContext(), FormUploadActivity.class);
        foodList.putExtra("EmployeeId",txtName.getText().toString());
        itemView.getContext().startActivity(foodList);
    }
}

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder>{

    private List<Employee> listData= new ArrayList<>();
    private Context context;

    public CartAdapter(List<Employee> listData, Context context) {
        this.listData = listData;
        this.context = context;
    }

    @Override
    public CartViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View itemview=inflater.inflate(R.layout.item_employee,parent,false);
        return new CartViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {
        holder.txtName.setText(listData.get(position).getName());
        holder.txtPhone.setText(listData.get(position).getPhone());
        holder.txtAdd.setText(listData.get(position).getAddress());
        holder.txtAge.setText(listData.get(position).getAge());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }
}
