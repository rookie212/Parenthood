package com.humber.parenthood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.humber.parenthood.databinding.ActivityMainBinding;
import com.humber.parenthood.eat_in_layout.IngredientPicker;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //replaceFragement(new IngredientPicker());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()){
                case R.id.eat_options:
                    replaceFragement(new IngredientPicker());
                    break;
                case R.id.groceries:
                    break;
                case R.id.chat:
                    break;
                case R.id.setting:
                    replaceFragement(new SettingsFragment());
                    break;
            }
            return true;
        });
    }

    private void replaceFragement(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentScreen, fragment);
        fragmentTransaction.commit();
    }
}