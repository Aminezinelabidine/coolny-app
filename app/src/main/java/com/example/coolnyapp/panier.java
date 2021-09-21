package com.example.coolnyapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class panier extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton add_button;
    ImageView empty_imageview;
    TextView no_data;
    double total=0;

    MyDatabaseHelper myDB;
    ArrayList<String> idProduit, nomProduit, prixProduit, qteProduit,ligneCommande;
    String tmp;


    ArrayList<String> listItems=new ArrayList<String>();
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listeCommande = (ListView)findViewById(R.id.listCommande);

        myDB = new MyDatabaseHelper(panier.this);

        Cursor cursor = myDB.readAllData();

       while (cursor.moveToNext()) {
           tmp = cursor.getString(3) + " x " + cursor.getString(1).toString() + " = " + cursor.getString(4) + " DT";
           total+=Double.valueOf(cursor.getString(4));
           listItems.add(tmp);
       }
        listItems.add("Total de la commande : "+String.format("%.3f", total)+" DT");


        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                listItems);
        listeCommande.setAdapter(adapter);
        //ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.activity_panier,ligneCommande);
        //listeCommande.setAdapter(arrayAdapter);

        /*customAdapter = new CustomAdapter(panier.this, this, idProduit, nomProduit, prixProduit,qteProduit);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(panier.this));
*/




        Toast.makeText(this, String.valueOf(myDB.readAllData().getColumnCount()), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            recreate();
        }
    }

    void storeDataInArrays() {
        Cursor cursor = myDB.readAllData();
            while (cursor.moveToNext()) {
                idProduit.add(cursor.getString(0));
                nomProduit.add(cursor.getString(1));
                prixProduit.add(cursor.getString(2));
                qteProduit.add(cursor.getString(3));
            }

        }





}