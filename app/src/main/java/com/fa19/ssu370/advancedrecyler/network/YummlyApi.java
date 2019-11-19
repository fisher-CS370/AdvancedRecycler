package com.fa19.ssu370.advancedrecyler.network;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class YummlyApi {

    private static final String baseApiUrl = "http://api.yummly.com/v1/api/recipes";
    private static final String apiKey = "ec3e34e0bb6801670dbd3dbd02ce7608";
    private static final String appId = "4911b643";


    /**
     * Searches the YummlyApi recipe database.
     * @param input the ingredient to search in recipes
     * @return string: json response containing matches
     */
    public static String searchRecipes(String input) {

        // piece together a valid url, starting with the base
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseApiUrl).newBuilder();

        // and adding on a few more parts
        urlBuilder.addQueryParameter("_app_key", apiKey);
        urlBuilder.addQueryParameter("_app_id", appId);
        urlBuilder.addQueryParameter("q", input);
        urlBuilder.addQueryParameter("maxResult", "40");

        // until it's ready to assemble
        String url = urlBuilder.build().toString();

        return getResponse(url);
    }

    private static String getResponse(String url) {
        // form the Request with the url
        Request request = new Request.Builder().url(url).build();

        OkHttpClient client = new OkHttpClient();
        try {
            // ask the server for a response
            Response response = client.newCall(request).execute();
            // `response` also contains metadata: success/fail, travel time, etc.
            // only need the body of the result (as a string)
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}