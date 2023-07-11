package com.humber.parenthood;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.humber.parenthood.databinding.ActivityEatOutBinding;

import java.util.Objects;

public class EatOutActivity extends AppCompatActivity {
    ActivityEatOutBinding a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a = ActivityEatOutBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());
        Objects.requireNonNull(getSupportActionBar()).setTitle("Eat out");

    }
}