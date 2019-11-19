package com.fa19.ssu370.advancedrecyler.network;

import android.os.AsyncTask;
import android.util.Log;

import com.fa19.ssu370.advancedrecyler.model.RecipeModel;
import com.fa19.ssu370.advancedrecyler.utility.RecipeParser;

import java.util.List;

public class RecipeSearchAsyncTask extends AsyncTask<String, Void, List<RecipeModel>> {

// AsyncTask is a templated (generic) class: AsyncTask<PARAMS, PROGRESS, RESULT>

// PARAMS is the datatype that we pass to execute()
//      a String representing an ingredient to search for recipes that use it
//      (from user input in MainActivity)
// PROGRESS is the datatype we use to report updates
//      not used in this lab -> Void (null)
// RESULT is the datatype that we send back on completion of this task
//      a List of RecipeModel (List<RecipeModel>) that represents all the results for the ingredient


    // instance of a RecipeListener (concrete implementation)
    private RecipeListener listener;

    // setter
    public void setListener(RecipeListener listener) {
        this.listener = listener;
    }


    @Override
    protected List<RecipeModel> doInBackground(String... params) {
        // runs on a background thread, not blocking main

        String searchTerm = params[0];  // what we're searching for
        Log.d("SearchAsyncTask", "doInBackground: " + searchTerm);

        // get the json response from Yummly's Recipe API
        String responseJson = YummlyApi.searchRecipes(searchTerm);
        // can't go further until the search comes back with results


        // success? :)
        if (responseJson != null) {
            // get useful data from the response
            List<RecipeModel> recipeModelList = RecipeParser.getMatches(responseJson);
            return recipeModelList;
        }
        // no success :(
        return null;
    }

    @Override
    protected void onPostExecute(List<RecipeModel> recipeModels) {
        // happens after doInBackground, and runs on main thread
        super.onPostExecute(recipeModels);
        Log.d("SearchAsyncTask", "onPostExecute: " + recipeModels);
        listener.onRecipeCallback(recipeModels);
    }


    public interface RecipeListener {
        void onRecipeCallback(List<RecipeModel> models);
    }

}