package com.example.coolnyapp;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class productForm extends AppCompatActivity {

    public String prodID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productform);
        TextView name = findViewById(R.id.productName);


        setContentView(R.layout.productform);
        Bundle bundle = getIntent().getExtras();

        if (bundle!= null) {
            String prodID = getIntent().getStringExtra("prodID");
            name.setText(prodID);
        }
    }


}

