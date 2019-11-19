package com.fa19.ssu370.advancedrecyler;

import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fa19.ssu370.advancedrecyler.model.RecipeModel;

import androidx.recyclerview.widget.RecyclerView;

public class RecipeViewHolder extends RecyclerView.ViewHolder {

    private ImageView itemRecipeImage;
    private TextView itemNameTextView;

    public RecipeViewHolder(View itemView) {
        super(itemView);
        itemRecipeImage = itemView.findViewById(R.id.recipe_image);
        itemNameTextView = itemView.findViewById(R.id.recipe_name);

    }

    public void bindView(final RecipeModel model, final OnRecyclerItemClickListener listener) {
        Glide.with(this.itemView)
                .load(model.getSmallImageUrls().get(0))
                .into(itemRecipeImage);

        itemNameTextView.setText(model.getRecipeName());

        // Each RecipeViewHolder is backed by a View and can therefore have an OnClickListener.
        // We can use the OnClickListener to determine when we need to fire the method in our OnRecyclerItemClickListener
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onRecyclerItemClick(model);
            }
        });
    }
}