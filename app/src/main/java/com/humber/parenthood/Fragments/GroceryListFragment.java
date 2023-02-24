package com.humber.parenthood.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.humber.parenthood.R;
import com.humber.parenthood.databinding.FragmentGroceryListBinding;

public class GroceryListFragment extends Fragment {

    FragmentGroceryListBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (binding == null) binding = FragmentGroceryListBinding.inflate(inflater, container, false);



        return binding.getRoot();
    }
}