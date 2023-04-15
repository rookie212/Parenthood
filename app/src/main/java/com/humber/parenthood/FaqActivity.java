package com.humber.parenthood;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.humber.parenthood.databinding.ActivityFaqBinding;

import java.util.ArrayList;
import java.util.List;

public class FaqActivity extends AppCompatActivity {

    ActivityFaqBinding a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        a = ActivityFaqBinding.inflate(getLayoutInflater());
        setContentView(a.getRoot());
        getSupportActionBar().setTitle("FAQ");
        // Create a list of QAModel items
        List<QAModel> qaList = new ArrayList<>();
        qaList.add(new QAModel("What is your return policy?", "Our return policy allows for returns up to 30 days after purchase."));
        qaList.add(new QAModel("How do I track my order?", "You can track your order on our website using your order number."));
        qaList.add(new QAModel("Do you offer international shipping?", "Yes, we offer international shipping to select countries."));
        qaList.add(new QAModel("What is your customer service number?", "Our customer service number is 1-800-123-4567."));
        qaList.add(new QAModel("How do I cancel an order?", "Please contact our customer service team to cancel your order."));

// Create a new FAQAdapter instance with the qaList
        FAQAdapter adapter = new FAQAdapter(qaList);

// Set the adapter on your RecyclerView
        a.recyclerView.setAdapter(adapter);

    }
}