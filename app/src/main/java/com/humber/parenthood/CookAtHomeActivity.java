package com.humber.parenthood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.humber.parenthood.databinding.ActivityCookAtHomeBinding;

public class CookAtHomeActivity extends AppCompatActivity {

    ActivityCookAtHomeBinding a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a = ActivityCookAtHomeBinding.inflate(getLayoutInflater());
        getSupportActionBar().setTitle("Cook at home");
        setContentView(a.getRoot());
    }
}