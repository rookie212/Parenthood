package com.humber.parenthood;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

        IngrediantPicker ingrediantPicker = new IngrediantPicker();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragementScreen, ingrediantPicker)
                .commit();

        btnEat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragementScreen, ingrediantPicker)
                        .commit();
            }
        });
    }
}