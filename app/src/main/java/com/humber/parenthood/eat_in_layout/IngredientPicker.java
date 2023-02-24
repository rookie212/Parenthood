package com.humber.parenthood.eat_in_layout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.humber.parenthood.R;

import java.util.ArrayList;

public class IngredientPicker extends Fragment {
    private ItemAdaptor adapter;
    private ArrayList<ItemModel> modelArrayList;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ingredient_picker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        modelArrayList = new ArrayList<>();

        recyclerView = view.findViewById(R.id.itemsRV);

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
}