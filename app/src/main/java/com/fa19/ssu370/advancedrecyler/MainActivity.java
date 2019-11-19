package com.fa19.ssu370.advancedrecyler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fa19.ssu370.advancedrecyler.model.RecipeModel;
import com.fa19.ssu370.advancedrecyler.network.RecipeSearchAsyncTask;

import org.parceler.Parcels;

import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private EditText searchEditText;
    private Button searchButton;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEditText = findViewById(R.id.search_edit_text);
        searchButton = findViewById(R.id.recipe_search_button);
        recyclerView = findViewById(R.id.recycler_view);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(layoutManager);



        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecipeSearchAsyncTask task = new RecipeSearchAsyncTask();
                task.setListener(new RecipeSearchAsyncTask.RecipeListener() {
                    @Override
                    public void onRecipeCallback(List<RecipeModel> models) {
                        RecipeViewAdapter adapter;

                        // creating an inline instance of the listener to pass to the RecipeViewAdapter
                        OnRecyclerItemClickListener listener = new OnRecyclerItemClickListener() {
                            @Override
                            public void onRecyclerItemClick(RecipeModel model) {

                                //do some stuff after item click
                                return;
                            }
                        };

                        adapter = new RecipeViewAdapter(models, listener);
                        recyclerView.setAdapter(adapter);
                    }
                });
                task.execute(searchEditText.getText().toString());
            }
        });
    }
}
