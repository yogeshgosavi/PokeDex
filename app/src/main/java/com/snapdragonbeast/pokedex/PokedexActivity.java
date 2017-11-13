package com.snapdragonbeast.pokedex;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PokedexActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);
    }

    public void PokemonClick(View view) {
        ImageButton imageButton = (ImageButton)view;
        String tag = (imageButton).getTag().toString();

        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("pokemon_name",tag);
        startActivity(intent);
    }
}
