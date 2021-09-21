package com.example.coolnyapp;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListProducts extends ArrayAdapter<String> {

    private final Activity context;
    public final String[] productid;
    private final String[] name;
    private final String[] price;
   // private final Integer[] imgid;

    public ListProducts(Activity context, String[] id, String[] name, String[] price) {
        super(context, R.layout.listproducts, name);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.productid=id;
        this.name=name;
        this.price = price;
       // this.imgid=imgid;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listproducts, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
       // ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);
        TextView prodid = (TextView) rowView.findViewById(R.id.pid);


        titleText.setText(name[position]);
        //imageView.setImageResource(imgid[position]);
        subtitleText.setText(price[position]);
        prodid.setText(productid[position]);

        return rowView;

    };


}
