package com.humber.parenthood.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;

import com.firebase.ui.auth.AuthUI;
import com.humber.parenthood.Dialogs.BottomSheetDialog;
import com.humber.parenthood.Dialogs.ClearData;
import com.humber.parenthood.FaqActivity;
import com.humber.parenthood.SharedPreference;
import com.humber.parenthood.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment {

    SharedPreference sharedPreference;
    private FragmentSettingsBinding a;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        a = FragmentSettingsBinding.inflate(inflater, container, false);

        sharedPreference = new SharedPreference(requireActivity());
        return a.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        a.signOut.setOnClickListener(v -> AuthUI.getInstance().signOut(requireActivity()).addOnCompleteListener(task -> requireActivity().finish()));

        if (sharedPreference.getBoolean("dark_mode")) {
            a.darkMode.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }


        a.darkMode.setOnClickListener(view1 -> {
            if (a.darkMode.isChecked()) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            sharedPreference.addBoolean("dark_mode", a.darkMode.isChecked());
        });

        a.clearData.setOnClickListener(v -> {
            ClearData clearData = new ClearData();
            clearData.show(getChildFragmentManager(), "");
        });

        a.privacy.setOnClickListener(v -> {
            BottomSheetDialog dialog = new BottomSheetDialog(
                    "Privacy policy",
                    "We take your privacy very seriously. This privacy policy outlines what information we collect, how we use it, and how we protect it.\n" +
                            "\n" +
                            "Information We Collect\n" +
                            "We collect the following types of information when you use our app:\n" +
                            "\n" +
                            "Personal Information: We collect your name and email address when you create an account.\n" +
                            "Usage Information: We collect information about how you use our app, including the features you use and the pages you visit.\n" +
                            "Device Information: We collect information about the device you use to access our app, including the type of device, operating system, and device settings.\n" +
                            "How We Use Your Information\n" +
                            "We use your information to provide and improve our app. Specifically, we use your information to:\n" +
                            "\n" +
                            "We take appropriate measures to protect your information from unauthorized access, alteration, or disclosure. These measures include:\n" +
                            "\n" +
                            "Using encryption to protect your data\n" +
                            "Limiting access to your data to authorized personnel only\n" +
                            "Regularly monitoring our systems for security vulnerabilities\n" +
                            "Sharing Your Information\n" +
                            "We do not share your personal information with third parties, except in the following cases:\n" +
                            "\n" +
                            "Our app is not intended for children under the age of 13, and we do not knowingly collect information from children under 13.\n" +
                            "\n" +
                            "Changes to Our Privacy Policy\n" +
                            "We may update our privacy policy from time to time. If we make any material changes, we will notify you by email or by posting a notice on our app.\n" +
                            "\n" +
                            "Contact Us\n" +
                            "If you have any questions or concerns about our privacy policy, please contact us at support@parenthoodapp.com.\n" +
                            "\n"
            );
            dialog.show(getChildFragmentManager(), "");
        });
        a.terms.setOnClickListener(v -> {
            BottomSheetDialog dialog = new BottomSheetDialog(
                    "Terms of service",
                    "Use of the App\n" +
                            "You may use Parenthood App for personal, non-commercial purposes only. You may not use the app for any illegal or unauthorized purpose.\n" +
                            "\n" +
                            "Disclaimer of Warranties\n" +
                            "Parenthood App is provided on an \"as is\" and \"as available\" basis, without any warranties of any kind, express or implied.\n" +
                            "\n" +
                            "Limitation of Liability\n" +
                            "Parenthood App will not be liable for any damages arising from the use of the app, including but not limited to direct, indirect, incidental, punitive, and consequential damages."
            );
            dialog.show(getChildFragmentManager(), "");
        });
        a.faq.setOnClickListener(v -> startActivity(new Intent(requireActivity(), FaqActivity.class)));


    }
}