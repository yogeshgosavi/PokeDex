package com.snapdragonbeast.pokedex;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Scanner;

public class DetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        String pokemon_name = intent.getStringExtra("pokemon_name");
        LinearLayout layout = (LinearLayout) findViewById(R.id.pokemondetailslayout);

        setPokemonName(pokemon_name, layout);
    }

    private void setPokemonName(String pokemon_name, LinearLayout layout) {

//// String name2 = name.replace( " " ,"").toLowerCase();
//        int flagImageID = getResources().getIdentifier( name2 ,"drawable",getPackageName());
//
//        ImageButton imageButton = (ImageButton) view.findViewById(R.id.image_flag);
//        imageButton.setImageResource(flagImageID);

        //file id
        String file = pokemon_name.toLowerCase();
        int fileID = getResources().getIdentifier(file, "raw", getPackageName());

        //Read file
        Scanner scanner = new Scanner(getResources().openRawResource(fileID));
        String allText = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            allText += line;
        }
        scanner.close();

        TextView textView1= (TextView)layout.findViewById(R.id.pokemonDetails);
        textView1.setText(allText);
        // to set Pokemon name
        TextView textView = (TextView)layout.findViewById(R.id.pokemonName);
        textView.setText(pokemon_name.toUpperCase());

        //settting image
        String name2 = pokemon_name.toLowerCase();
        int ImgID = getResources().getIdentifier(name2, "drawable", getPackageName());
        ImageView imageView = (ImageView) layout.findViewById(R.id.pokemonImage);
        imageView.setImageResource(ImgID);


    }



}
