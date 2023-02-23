package com.humber.parenthood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.firebase.ui.auth.AuthUI;

public class SettingsFragment extends Fragment {
    public SettingsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button signOutButton = requireView().findViewById(R.id.btn_sign_out);
        signOutButton.setOnClickListener(v -> AuthUI.getInstance().signOut(requireActivity()).addOnCompleteListener(task -> requireActivity().finish()));
    }
}