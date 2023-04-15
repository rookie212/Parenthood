package com.humber.parenthood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.humber.parenthood.databinding.ActivityEatOutBinding;

public class EatOutActivity extends AppCompatActivity {
    ActivityEatOutBinding a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a = ActivityEatOutBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());
        getSupportActionBar().setTitle("Eat out");

    }
}