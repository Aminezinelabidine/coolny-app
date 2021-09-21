package com.example.coolnyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class HomeScreen extends AppCompatActivity {

    public String shared = "";
    String CATID="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        Button ep = (Button) findViewById(R.id.epicerie);

        ep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeScreen.this, ListeProduits.class);
                intent.putExtra("catID","3");
                startActivity(intent);
            }
        });


        Button of = (Button) findViewById(R.id.pret_a_offrir);

        of.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeScreen.this, ListeProduits.class);
                intent.putExtra("catID","2");
                startActivity(intent);
            }
        });

        Button deg = (Button) findViewById(R.id.pret_a_deg);

        deg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeScreen.this, ListeProduits.class);
                intent.putExtra("catID","1");
                startActivity(intent);
            }
        });


        Button creation = (Button) findViewById(R.id.creation);
        creation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeScreen.this, biscuitpersonnaliser.class);
                startActivity(intent);
            }
        });


        Button pan = (Button) findViewById(R.id.panier);
        pan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HomeScreen.this, panier.class);
                startActivity(intent);
            }
        });





    }
}