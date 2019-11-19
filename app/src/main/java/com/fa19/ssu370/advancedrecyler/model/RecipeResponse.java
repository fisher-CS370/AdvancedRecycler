package com.fa19.ssu370.advancedrecyler.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RecipeResponse {

    @SerializedName("matches")
    private List<RecipeModel> recipes;

    public List<RecipeModel> getRecipes() {
        return recipes;
    }
}


// request:
// http://api.yummly.com/v1/api/recipes?_app_key=ec3e34e0bb6801670dbd3dbd02ce7608&_app_id=4911b643&q=lemon

// response:
/*
// the response is one big object
{
  // totalMatchCount is an integer
  "totalMatchCount": 272166,
  // criteria is a named object (criteria-object is nested inside response-object)
  "criteria": {
    "q": "lemon",
    "allowedIngredient": null,
    "excludedIngredient": null
  },
  // matches is an Array, containing Objects
  "matches": [
    // list of unnamed json objects (recipes) (shortened for example)
    {
      "sourceDisplayName": "I Save A2Z",
      "id": "Homemade-Blue-Lemonade-2536078",
      "recipeName": "Homemade Blue Lemonade"
    },
    {
      "sourceDisplayName": "Dessert for Two",
      "id": "Lemon-Meltaways-2424036",
      "recipeName": "Lemon Meltaways"
    },
    {
      "sourceDisplayName": "Living Fresh Daily",
      "id": "Cucumber-Lemon-Ginger-Water-2654197",
      "recipeName": "Cucumber Lemon Ginger Water"
    },
    {
      "sourceDisplayName": "Saving Room for Dessert",
      "id": "Lemon-Meltaways-1985782",
      "recipeName": "Lemon Meltaways"
    },
    {
      "sourceDisplayName": "Wishes and Dishes",
      "id": "Sunshine-Lemon-Smoothie-1624943",
      "recipeName": "Sunshine Lemon Smoothie"
    },
    {
      "sourceDisplayName": "Jo Cooks",
      "id": "Lemon-Chicken-Piccata-2238756",
      "recipeName": "Lemon Chicken Piccata"
    }
  ],
  // another object
  "attribution": {
    "html": "Recipe search powered by <a href='http://www.yummly.co/recipes'><img alt='Yummly' src='https://static.yummly.co/api-logo.png'/></a>",
    "url": "http://www.yummly.co/recipes/",
    "text": "Recipe search powered by Yummly",
    "logo": "https://static.yummly.co/api-logo.png"
  }
}
*/
// end of response object
