package com.humber.parenthood.eat_in_layout;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.humber.parenthood.CookAtHomeActivity;
import com.humber.parenthood.OpenAIAsyncTask;
import com.humber.parenthood.R;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.service.OpenAiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class IngredientPicker extends Fragment {
    private final ArrayList<String> fridgeItems = KitchenItems.getItems();
    private final String OPENAI_SERVICE_TOKEN = "";
    private ItemAdaptor adapter;
    private ArrayList<ItemModel> modelArrayList;
    private final ItemClickListener itemClickListener = new ItemClickListener() {
        @Override
        public void onClick(ItemModel items) {

//            Log.d("@Harman", "onClick: item select");
            int position = modelArrayList.indexOf(items);
            if (position != RecyclerView.NO_POSITION) {
                ItemModel item = modelArrayList.get(position);
                item.setSelected(!item.getSelected());
                adapter.notifyItemChanged(position);
            }
        }

        @Override
        public void onLongClick(ItemModel items) {
//            Log.d("@Harman", "onLongClick: item fav");
            int position = modelArrayList.indexOf(items);
            if (position != RecyclerView.NO_POSITION) {
                ItemModel item = modelArrayList.get(position);
                item.setFavourite(!item.getFavourite());
                adapter.notifyItemChanged(position);
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ingredient_picker, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        modelArrayList = new ArrayList<>();

        RecyclerView recyclerView = view.findViewById(R.id.itemsRV);
        Button printSelectionButton = view.findViewById(R.id.button2);
        SearchView searchBar = view.findViewById(R.id.search_bar);
        setItems(modelArrayList);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 4));
        adapter = new ItemAdaptor(modelArrayList, view.getContext());

        recyclerView.setAdapter(adapter);

        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Filter the modelArrayList based on the query text
                ArrayList<ItemModel> filteredList = filter(modelArrayList, newText);

                // Update the adapter with the filtered list
                adapter.updateList(filteredList);
                adapter.notifyDataSetChanged();

                return true;
            }
        });


        printSelectionButton.setOnClickListener(v -> {
            if (OPENAI_SERVICE_TOKEN.equals("")) {
                Toast.makeText(getContext(), "Please add your OpenAI service token in IngredientPicker.java", Toast.LENGTH_LONG).show();
                return;
            }
            ArrayList<String> selectedItems = new ArrayList<>();
            for (ItemModel model : modelArrayList) {
                if (model.selected) {
//                        Log.d("@Harman", model.getName());
                    selectedItems.add(model.getName());
                }
            }
            String prompt = "make a random recipe";
            if (selectedItems.size() != 0) {
                prompt = "I have " + selectedItems + " in my fridge. Can you provide me a recipe with these items?";
            }
            OpenAiService openAiService = new OpenAiService(OPENAI_SERVICE_TOKEN);
            CompletionRequest completionRequest = CompletionRequest.builder()
                    .prompt(prompt)
                    .model("gpt-3.5-turbo")
                    .temperature(1.0)
                    .maxTokens(4000)
                    .echo(true)
                    .build();
            new OpenAIAsyncTask(openAiService, completionRequest, new Callback<CompletionResult>() {
                @Override
                public void onResponse(@NonNull Call<CompletionResult> call, @NonNull Response<CompletionResult> response) {
                    assert response.body() != null;
//                    Toast.makeText(getContext(), response.body().getChoices().get(0).getText(), Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(requireActivity(), CookAtHomeActivity.class);
                    intent.putExtra("recipe", response.body().getChoices().get(0).getText());
                    startActivity(intent);
                }

                @Override
                public void onFailure(@NonNull Call<CompletionResult> call, @NonNull Throwable t) {
                    t.printStackTrace();
                }
            }).execute();

//            Log.d("@Harman", "Can you provide me a recipe with these items: " + selectedItems);
        });

        // Set the listener on the adapter
        adapter.setItemClickListener(itemClickListener);
    }

    private void setItems(ArrayList<ItemModel> modelArrayList) {
        for (int i = 0; i < fridgeItems.size(); i++) {
            modelArrayList.add(new ItemModel(fridgeItems.get(i)));
        }
    }

    private ArrayList<ItemModel> filter(ArrayList<ItemModel> models, String query) {
        ArrayList<ItemModel> filteredList = new ArrayList<>();
        for (ItemModel model : models) {
            if (model.getName().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(model);
            }
        }
        return filteredList;
    }
}