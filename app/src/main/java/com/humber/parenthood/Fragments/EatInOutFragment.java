package com.humber.parenthood.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.humber.parenthood.databinding.FragmentEatInOutBinding;

public class EatInOutFragment extends Fragment {

    FragmentEatInOutBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (binding == null) binding = FragmentEatInOutBinding.inflate(inflater, container, false);



        return binding.getRoot();
    }
}
