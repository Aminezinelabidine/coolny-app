package com.example.coolnyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class biscuitpersonnaliser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biscuitpersonnaliser);

        TextView ligne1 = (TextView) findViewById(R.id.lbligne1);
        TextView ligne2 = (TextView) findViewById(R.id.lbligne2);
        TextView ligne3 = (TextView) findViewById(R.id.lbligne3);

        EditText txt1 = (EditText) findViewById(R.id.lbltext1);
        EditText txt2 = (EditText) findViewById(R.id.lbltext2);
        EditText txt3 = (EditText) findViewById(R.id.lbltext3);


        txt1.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               // doSomething();
                ligne1.setText(txt1.getText());
            }
        });


        txt2.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // doSomething();
                ligne2.setText(txt2.getText());
            }
        });

        txt3.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // doSomething();
                ligne3.setText(txt3.getText());
            }
        });


    }
}