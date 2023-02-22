package com.humber.parenthood;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnEat, btnGroceries, btnChat, btnSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEat = findViewById(R.id.eat);
        btnGroceries = findViewById(R.id.groceries);
        btnChat = findViewById(R.id.chat);
        btnSettings = findViewById(R.id.settings);

        IngredientPicker ingredientPicker = new IngredientPicker();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragementScreen, ingredientPicker)
                .commit();

        btnEat.setOnClickListener(view -> getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragementScreen, ingredientPicker)
                .commit());
    }
}