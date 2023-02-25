package com.humber.parenthood.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.humber.parenthood.R;
import com.humber.parenthood.databinding.FragmentChatBinding;
import com.humber.parenthood.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment {

    FragmentSettingsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (binding == null) binding = FragmentSettingsBinding.inflate(inflater, container, false);



        return binding.getRoot();
    }
}