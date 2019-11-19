package com.fa19.ssu370.advancedrecyler;

import com.fa19.ssu370.advancedrecyler.model.RecipeModel;

// listener interface that we will use to communicate clicks from the RecipeViewHolder to the MainActivity
public interface OnRecyclerItemClickListener {
    void onRecyclerItemClick(RecipeModel model);
}
