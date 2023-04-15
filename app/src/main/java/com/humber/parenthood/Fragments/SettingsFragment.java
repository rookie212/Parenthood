package com.humber.parenthood.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.humber.parenthood.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment {

    FragmentSettingsBinding a;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (a == null) a = FragmentSettingsBinding.inflate(inflater, container, false);


        return a.getRoot();
    }
}