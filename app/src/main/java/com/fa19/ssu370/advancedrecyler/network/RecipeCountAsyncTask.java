package com.fa19.ssu370.advancedrecyler.network;

import android.os.AsyncTask;
import android.util.Log;

import com.fa19.ssu370.advancedrecyler.utility.RecipeParser;

public class RecipeCountAsyncTask extends AsyncTask<String, Void, Integer> {

// AsyncTask is a templated (generic) class: AsyncTask<PARAMS, PROGRESS, RESULT>

// PARAMS is the datatype that we pass to execute()
//      a String representing an ingredient to search for recipes that use it
//      (from user input in MainActivity)
// PROGRESS is the datatype we use to report updates
//      not used in this lab -> Void (null)
// RESULT is the datatype that we send back on completion of this task
//      an Integer (int) that represents the number of recipes that use the ingredient


    // instance of a RecipeListener (concrete implementation)
    private RecipeListener listener;

    // setter
    public void setListener(RecipeListener listener) {
        this.listener = listener;
    }

    @Override
    protected Integer doInBackground(String... params) {
        // runs on a background thread, not blocking main

        String searchTerm = params[0];  // what we're searching for
        Log.d("CountAsyncTask", "doInBackground: " + searchTerm);

        // get the json response from Yummly's Recipe API
        String responseJson = YummlyApi.searchRecipes(searchTerm);
        // can't go further until the search comes back with results


        // success? :)
        if (responseJson != null) {
            int numMatches = RecipeParser.getTotalMatches(responseJson);
            return numMatches;
        }
        // no success :(
        return 0;
    }

    @Override
    protected void onPostExecute(Integer result) {
        // happens after doInBackground, and runs on main thread
        super.onPostExecute(result);
        Log.d("CountAsyncTask", "onPostExecute: " + result);

        if (this.listener != null) {
            this.listener.onRecipeCountCallback(result);
        }
    }


    // just a type description/prototype -- not a usable object!
    public interface RecipeListener {
        void onRecipeCountCallback(Integer result);
    }

}
