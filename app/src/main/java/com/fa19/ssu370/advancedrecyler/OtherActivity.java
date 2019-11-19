package com.fa19.ssu370.advancedrecyler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.fa19.ssu370.advancedrecyler.model.RecipeModel;

import org.parceler.Parcels;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        Intent intent = getIntent();
        RecipeModel receivedModel = Parcels.unwrap(intent.getBundleExtra("MyModel"));
        return;
    }
}
