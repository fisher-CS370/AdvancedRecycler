package com.fa19.ssu370.advancedrecyler;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fa19.ssu370.advancedrecyler.model.RecipeModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeViewAdapter extends RecyclerView.Adapter<RecipeViewHolder> {
    private String TAG = "RecipeViewAdapter";

    private List<RecipeModel> recipeCollection;
    private final OnRecyclerItemClickListener clickListener;

    public RecipeViewAdapter(List<RecipeModel> collection, OnRecyclerItemClickListener listener) {
        recipeCollection = collection;
        clickListener = listener;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_list_item, parent, false);
        return new RecipeViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder recipeViewHolder, int position) {
        Log.d(TAG, "onBindViewHolder: " + position);
        recipeViewHolder.bindView(recipeCollection.get(position), clickListener);
    }

    @Override
    public int getItemCount() {
        return recipeCollection.size();
    }
}
