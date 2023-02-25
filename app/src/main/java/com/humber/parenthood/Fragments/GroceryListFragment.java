package com.humber.parenthood.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.humber.parenthood.databinding.FragmentGroceryListBinding;

public class GroceryListFragment extends Fragment {

    FragmentGroceryListBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (binding == null) binding = FragmentGroceryListBinding.inflate(inflater, container, false);



        return binding.getRoot();
    }
}