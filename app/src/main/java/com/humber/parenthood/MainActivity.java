package com.humber.parenthood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;
import com.humber.parenthood.Fragments.*;
import com.humber.parenthood.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    //    main layout binding
    ActivityMainBinding binding;
    FragmentManager fragmentManager;
    Fragment chatFragment;
    Fragment groceryFragment;
    Fragment settingsFragment;
    Fragment active;
    Fragment eatInOutFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        initializing
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        chatFragment = new ChatFragment();
        eatInOutFragment = new EatInOutFragment();
        settingsFragment = new SettingsFragment();
        groceryFragment = new GroceryListFragment();

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(binding.container.getId(), settingsFragment).hide(settingsFragment);
        fragmentTransaction.add(binding.container.getId(), groceryFragment).hide(groceryFragment);
        fragmentTransaction.add(binding.container.getId(), eatInOutFragment).hide(eatInOutFragment);
        fragmentTransaction.add(binding.container.getId(), chatFragment);
        fragmentTransaction.commitNow();
        active = chatFragment;
        getSupportActionBar().setTitle("Chat");

        binding.btm.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.chat) {
                    changeFragment(chatFragment);
                    getSupportActionBar().setTitle("Chat");
                } else if (itemId == R.id.groceries) {
                    changeFragment(groceryFragment);
                    getSupportActionBar().setTitle("Groceries List");

                } else if (itemId == R.id.settings) {
                    changeFragment(settingsFragment);
                    getSupportActionBar().setTitle("Settings");

                } else if (itemId == R.id.eat) {
                    changeFragment(eatInOutFragment);
                    getSupportActionBar().setTitle("Eat In/Out");

                }
                return true;
            }
        });

    }

    private void changeFragment(Fragment fragment){
        fragmentManager.beginTransaction().hide(active).show(fragment).commit();
        active = fragment;
    }
}