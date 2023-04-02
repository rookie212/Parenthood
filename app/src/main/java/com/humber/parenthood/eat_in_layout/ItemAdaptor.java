package com.humber.parenthood.eat_in_layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.humber.parenthood.R;

import java.util.ArrayList;

public class ItemAdaptor extends RecyclerView.Adapter <ItemAdaptor.ViewHolder> {
    private ArrayList<ItemModel> modelArrayList;
    private ItemClickListener itemClickListener;
    private final Context context;
    public ItemAdaptor(ArrayList<ItemModel> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public ItemAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // view instance
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdaptor.ViewHolder holder, int position) {
        ItemModel model = modelArrayList.get(position);
        holder.name.setText(model.getName());
        CardView boarderCV = holder.itemView.findViewById(R.id.outerBoarder);
        CardView selectedCV = holder.itemView.findViewById(R.id.selectedBoarder);

        setFavouriteColor(model, boarderCV);
        setSelectedColor(model, selectedCV);

        holder.itemView.setOnClickListener(v -> {
            if(itemClickListener != null) {
                itemClickListener.onClick(model);
            }
        });

        holder.itemView.setOnLongClickListener(v -> {
            if(itemClickListener != null) {
                itemClickListener.onLongClick(model);
            }
            return true;
        });
    }

    private void setFavouriteColor(ItemModel model, CardView favCard) {
        if(model.favourite) {
            favCard.setCardBackgroundColor(context.getResources().getColor(R.color.favourite_yellow));
        }
        else {
            favCard.setCardBackgroundColor(context.getResources().getColor(R.color.default_selected));
        }
    }

    private void setSelectedColor(ItemModel model, CardView selCard) {
        if(model.selected) {
            selCard.setCardBackgroundColor(context.getResources().getColor(R.color.black));
        }
        else {
            selCard.setCardBackgroundColor(context.getResources().getColor(R.color.white));
        }
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_name);
        }
    }

    public void updateList(ArrayList<ItemModel> filteredList) {
        this.modelArrayList = filteredList;
    }

}

