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
import com.humber.parenthood.databinding.BottomSheetBinding;


public class BottomSheetDialog extends BottomSheetDialogFragment {

    private final String title;
    private final String message;
    private BottomSheetBinding binding;

    public BottomSheetDialog(String title, String message) {
        this.title = title;
        this.message = message;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, R.style.TransParentBottomSheet);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (binding == null) {
            binding = BottomSheetBinding.inflate(inflater, container, false);
        }
        binding.cancel.setOnClickListener(v -> dismiss());

        binding.remove.setOnClickListener(v -> {
            Toast.makeText(requireContext(), "Accepted", Toast.LENGTH_SHORT).show();
            dismiss();
        });

        binding.title.setText(title);
        binding.message.setText(message);

        return binding.getRoot();
    }

}
