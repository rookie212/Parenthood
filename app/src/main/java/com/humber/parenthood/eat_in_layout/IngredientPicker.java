package com.humber.parenthood.eat_in_layout;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.widget.SearchView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.humber.parenthood.R;

import java.util.ArrayList;
import java.util.List;

public class IngredientPicker extends Fragment {
    private ItemAdaptor adapter;
    private ArrayList<ItemModel> modelArrayList;

    private final ArrayList<String> fridgeItems = KitchenItems.getItems();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ingredient_picker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        modelArrayList = new ArrayList<>();

        RecyclerView recyclerView = view.findViewById(R.id.itemsRV);
        Button printSelectionButton = view.findViewById(R.id.button2);
        SearchView searchBar = view.findViewById(R.id.search_bar);
        setItems(modelArrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 4));
        adapter = new ItemAdaptor(modelArrayList, view.getContext());

        recyclerView.setAdapter(adapter);

        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter the modelArrayList based on the query text
                ArrayList<ItemModel> filteredList = filter(modelArrayList, newText);

                // Update the adapter with the filtered list
                adapter.updateList(filteredList);

                return true;
            }
        });


        printSelectionButton.setOnClickListener(v -> {
            ArrayList<String> selectedItems = new ArrayList<>();
            for (ItemModel model : modelArrayList) {
                if (model.selected) {
//                        Log.d("@Harman", model.getName());
                    selectedItems.add(model.getName());
                }
            }
            Log.d("@Harman", "Can you provide me a recipe with these items: " + selectedItems);
        });

        // Set the listener on the adapter
        adapter.setItemClickListener(itemClickListener);
    }

    private void setItems(ArrayList<ItemModel> modelArrayList) {
        for (int i = 0; i < fridgeItems.size(); i++) {
            modelArrayList.add(new ItemModel(fridgeItems.get(i)));
        }
    }

    private final ItemClickListener itemClickListener = new ItemClickListener() {
        @Override
        public void onClick(ItemModel items) {

//            Log.d("@Harman", "onClick: item select");
            int position = modelArrayList.indexOf(items);
            if (position != RecyclerView.NO_POSITION) {
                ItemModel item = modelArrayList.get(position);
                item.setSelected(!item.getSelected());
                adapter.notifyItemChanged(position);
            }
        }

        @Override
        public void onLongClick(ItemModel items) {
//            Log.d("@Harman", "onLongClick: item fav");
            int position = modelArrayList.indexOf(items);
            if (position != RecyclerView.NO_POSITION) {
                ItemModel item = modelArrayList.get(position);
                item.setFavourite(!item.getFavourite());
                adapter.notifyItemChanged(position);
            }
        }
    };

    private ArrayList<ItemModel> filter(ArrayList<ItemModel> models, String query) {
        ArrayList<ItemModel> filteredList = new ArrayList<>();
        for (ItemModel model : models) {
            if (model.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(model);
            }
        }
        return filteredList;
    }
}