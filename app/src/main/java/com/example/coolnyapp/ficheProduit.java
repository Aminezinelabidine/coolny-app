package com.example.coolnyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.coolnyapp.Models.Commande;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ficheProduit extends AppCompatActivity {

    String url = "http://192.168.1.104/?apicall=getProductByID&id=";
    ProgressDialog dialog;



    Commande cmd = new Commande();
    public int idProd;
    Double prix ;

    public int qty = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche_produit);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);



        TextView idProduit = (TextView) this.findViewById(R.id.idProduit);
        TextView nomProduit = (TextView) this.findViewById(R.id.nomProduit);
        TextView prixProduit = (TextView) this.findViewById(R.id.prixProduit);
        TextView descriptionProduit = (TextView) this.findViewById(R.id.description);
        ImageView imgProduit = (ImageView) this.findViewById(R.id.imgProduit);



        TextView QTE = (TextView) this.findViewById(R.id.quantite);
        Button btnCommande = (Button) this.findViewById(R.id.btncommander);
        Bundle bundle = getIntent().getExtras();

        if (bundle!= null) {
            String prodID = getIntent().getStringExtra("prodID");
            url+=prodID;

            idProd=Integer.parseInt(prodID);

        }

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading....");
        dialog.show();

        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String string) {
                parseJsonData(string);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), "Some error occurred!!", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        RequestQueue rQueue = Volley.newRequestQueue(ficheProduit.this);
        rQueue.add(request);




        btnCommande.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView qte = (TextView) findViewById(R.id.quantite);
                MyDatabaseHelper myDB = new MyDatabaseHelper(ficheProduit.this);
                myDB.addCommande(nomProduit.getText().toString(),prix,Integer.parseInt(qte.getText().toString()));
                Toast.makeText(ficheProduit.this, nomProduit.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ficheProduit.this, HomeScreen.class);
                startActivity(intent);

            }
        });
    }


    void parseJsonData(String jsonString) {
        TextView idProduit = (TextView) this.findViewById(R.id.idProduit);
        TextView nomProduit = (TextView) this.findViewById(R.id.nomProduit);
        TextView prixProduit = (TextView) this.findViewById(R.id.prixProduit);
        TextView descriptionProduit = (TextView) this.findViewById(R.id.description);
        ImageView imgProduit = (ImageView) this.findViewById(R.id.imgProduit);
        try {
            JSONObject object = new JSONObject(jsonString);
            JSONArray productsArray = object.getJSONArray("products");
            String[] name= new String[productsArray.length()];
            String[] price= new String[productsArray.length()];
            String[] id= new String[productsArray.length()];
            String[] description= new String[productsArray.length()];
            String[] imgurl= new String[productsArray.length()];



            ArrayList al = new ArrayList();

            for(int i = 0; i < productsArray.length(); ++i) {
                JSONObject obj = productsArray.getJSONObject(i);

                name[i]=String.valueOf(obj.getString("name"));
                price[i]=obj.getString("price");
                id[i]=obj.getString("id");
                description[i]=obj.getString("description");
                imgurl[i]=obj.getString("imgURL");


            }

            idProduit.setText("ID:#"+id[0]);
            nomProduit.setText(name[0]);
            prixProduit.setText("Prix: "+price[0]+" DT"); prix=Double.parseDouble(price[0]);
            descriptionProduit.setText(description[0]);

            try {
                ImageView i = (ImageView)findViewById(R.id.image);
                Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(imgurl[0]).getContent());
                imgProduit.setImageBitmap(bitmap);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        dialog.dismiss();
    }


    }
