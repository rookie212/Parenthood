package com.humber.parenthood.eat_in_layout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.humber.parenthood.eat_in_layout.ItemOnClickListener;

import com.humber.parenthood.R;

import java.util.ArrayList;

public class IngredientPicker extends Fragment {
    ItemAdaptor adapter;
    ArrayList<ItemModel> modelArrayList;
    RecyclerView recyclerView;
    RecyclerView selectedRecyclerView;
    ItemAdaptor adaptor;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ingredient_picker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        modelArrayList = new ArrayList<>();

        recyclerView = view.findViewById(R.id.itemsRV);
        selectedRecyclerView = view.findViewById(R.id.selectedItemsRV);

        modelArrayList.add(new ItemModel("potato"));
        modelArrayList.add(new ItemModel("apple"));
        modelArrayList.add(new ItemModel("pear"));
        modelArrayList.add(new ItemModel("dragon"));
        modelArrayList.add(new ItemModel("potato"));
        modelArrayList.add(new ItemModel("apple"));
        modelArrayList.add(new ItemModel("pear"));
        modelArrayList.add(new ItemModel("dragon"));
        modelArrayList.add(new ItemModel("potato"));
        modelArrayList.add(new ItemModel("apple"));
        modelArrayList.add(new ItemModel("pear"));
        modelArrayList.add(new ItemModel("dragon"));
        modelArrayList.add(new ItemModel("potato"));
        modelArrayList.add(new ItemModel("apple"));
        modelArrayList.add(new ItemModel("pear"));
        modelArrayList.add(new ItemModel("dragon"));

        recyclerView.setLayoutManager(new GridLayoutManager (view.getContext(), 4));
        adapter = new ItemAdaptor(modelArrayList, view.getContext());
        recyclerView.setAdapter(adapter);
    }

    private void updateRecycler(ArrayList<ItemModel> items) {
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 4));
//        adaptor = new ItemAdaptor(IngredientPicker.this, items, ItemOnClickListener, mainDAO);
//        recyclerView.setAdapter(adaptor);
    }
}