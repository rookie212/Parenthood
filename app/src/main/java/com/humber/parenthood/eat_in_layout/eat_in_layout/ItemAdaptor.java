package com.humber.parenthood.eat_in_layout.eat_in_layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.humber.parenthood.R;

import java.util.ArrayList;

public class ItemAdaptor extends RecyclerView.Adapter <ItemAdaptor.ViewHolder>{
    private ArrayList<ItemModel> modelArrayList;

    public ItemAdaptor(ArrayList<ItemModel> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }

    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // view instance
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemModel model = modelArrayList.get(position);
        //holder.profileLetter.setText(model.getProfileLetter().toString());
        holder.name.setText(model.getName());
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // initialize profileLetter,name,number
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
        }
    }

}
