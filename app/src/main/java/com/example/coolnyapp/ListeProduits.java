package com.example.coolnyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.coolnyapp.Models.Produit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ListeProduits extends AppCompatActivity {
    String url = "http://192.168.1.104/?apicall=getProductsByCategory&id=";
    ProgressDialog dialog;
    String price[] ;
    String name[] ;
    String id[] ;

    ListView ProductList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_produits);




        Bundle bundle = getIntent().getExtras();

        if (bundle!= null) {
            String catID = getIntent().getStringExtra("catID");
            url+=catID;
            Toast.makeText(this, url, Toast.LENGTH_SHORT).show();

        }
        ProductList = (ListView)findViewById(R.id.listCommande);

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

        RequestQueue rQueue = Volley.newRequestQueue(ListeProduits.this);
        rQueue.add(request);
    }

    void parseJsonData(String jsonString) {
        try {
            JSONObject object = new JSONObject(jsonString);
            JSONArray productsArray = object.getJSONArray("products");
            String[] name= new String[productsArray.length()];
            String[] price= new String[productsArray.length()];
            String[] id= new String[productsArray.length()];


            ArrayList al = new ArrayList();

            for(int i = 0; i < productsArray.length(); ++i) {
                JSONObject obj = productsArray.getJSONObject(i);
                // al.add(obj.getString("name"));
                name[i]=String.valueOf(obj.getString("name"));
                price[i]=obj.getString("price")+" DT";
                id[i]=obj.getString("id");
            }



            ListProducts adapter=new ListProducts(this, id, name, price);
            ProductList=(ListView)findViewById(R.id.listCommande);
            ProductList.setAdapter(adapter);
            ProductList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    TextView c = (TextView) view.findViewById(R.id.pid);
                    String tmp = c.getText().toString();

                    Produit p = new Produit();
                    Intent intent = new Intent(ListeProduits.this, ficheProduit.class);
                    intent.putExtra("prodID",String.valueOf(tmp));
                    startActivity(intent);
                }
            });




        } catch (JSONException e) {
            e.printStackTrace();
        }

        dialog.dismiss();
    }

}