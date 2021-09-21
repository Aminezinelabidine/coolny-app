package com.example.coolnyapp.Models;

public class Produit {


    private int id;
        private String name;
        private double price;
        private int qty;
        private String description;

    public Produit() {
    }

    public int getId() {
        return id;
        }

         public void setId(int id) {
        this.id = id;
        }

        public String getname(){
            return name;
        }

        public void setname(String name){
            this.name =name;
        }

        public double getprice(){
            return price;
        }

        public void setprice(double productPrice){
            this.price=productPrice;
        }

        public int getqty(){
            return qty;
        }

        public void settqty(int productQty){
            this.qty=qty;
        }

        public String getdescription(){
            return description;
        }

        public void setDescription(String description){
            this.description=description;
        }
    }

