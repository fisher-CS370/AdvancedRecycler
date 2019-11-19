package com.fa19.ssu370.advancedrecyler.utility;

import android.util.Log;

import com.fa19.ssu370.advancedrecyler.model.RecipeModel;
import com.fa19.ssu370.advancedrecyler.model.RecipeResponse;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class RecipeParser {

    // TAG is used in logging, to help trace where output comes from
    private static final String TAG = "RecipeParser";

    /**
     * Returns a list of recipes that match a search term
     *
     * @param json String json representing the server's response
     * @return list of recipes (as RecipeModels)
     */
    public static List<RecipeModel> getMatches(String json) {
        // get list of RecipeModels from the ResponseModel and return
        Gson gson = new Gson();
        RecipeResponse response = gson.fromJson(json, RecipeResponse.class);
        return response.getRecipes();
    }

    /**
     * Gets total number of matched recipes in a search result.
     *
     * @param json string json representing the server's response
     * @return integer number of total matches
     */
    public static int getTotalMatches(String json) {
        int totalMatches = 0;

        try {
            // convert the raw string into a Java JSONObject
            JSONObject response = new JSONObject(json);

            // deserialize an integer
            totalMatches = response.getInt("totalMatchCount");

        } catch (JSONException e) {
            Log.e(TAG, "getTotalMatches: error parsing JSON", e);
        }

        return totalMatches;
    }
}

// http://api.yummly.com/v1/api/recipes?_app_key=ec3e34e0bb6801670dbd3dbd02ce7608&_app_id=4911b643&q=lemon

//language=JSON
/*
// beginning of JSON object (response from server)
{
  // totalMatchCount is an integer
  "totalMatchCount": 270009,
  // criteria is a (nested) JSON object
  "criteria": {
    "q": "lemon",  // q is a string
    "allowedIngredient": null,
    "excludedIngredient": null
  },
  "matches": [  // a JSON array
    // (list of recipes that matched)
    // (each one can be represented by a RecipeModel)
  ],
  "attribution": {
    "html": "Recipe search powered by <a href='http://www.yummly.co/recipes'><img alt='Yummly' src='https://static.yummly.co/api-logo.png'/></a>",
    "url": "http://www.yummly.co/recipes/",
    "text": "Recipe search powered by Yummly",
    "logo": "https://static.yummly.co/api-logo.png"
  }
}  // end of response object
 */