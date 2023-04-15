package com.humber.parenthood;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.humber.parenthood.databinding.ActivityCookAtHomeBinding;

import java.util.Objects;

public class CookAtHomeActivity extends AppCompatActivity {

    ActivityCookAtHomeBinding a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a = ActivityCookAtHomeBinding.inflate(getLayoutInflater());
        Objects.requireNonNull(getSupportActionBar()).setTitle("Cook at home");
        setContentView(a.getRoot());
        Bundle extras = getIntent().getExtras();
        TextView textView = findViewById(R.id.tv_cook_at_home_activity);
        if (extras != null) {
            String value = extras.getString("recipe");
            textView.setText(value);
            textView.setMovementMethod(new ScrollingMovementMethod());

        } else {
            textView.setText("No recipe found");
        }
    }
}