package com.humber.parenthood.Dialogs;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.humber.parenthood.R;
import com.humber.parenthood.databinding.ClearDataDialogBinding;


public class ClearData extends BottomSheetDialogFragment {

    private ClearDataDialogBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.TransParentBottomSheet);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (binding == null) {
            binding = ClearDataDialogBinding.inflate(inflater, container, false);
        }
        binding.cancel.setOnClickListener(v -> {
            dismiss();
        });

        binding.remove.setOnClickListener(v -> {
            Toast.makeText(requireContext(), "Cleared", Toast.LENGTH_SHORT).show();
            dismiss();
        });

        return binding.getRoot();
    }

}