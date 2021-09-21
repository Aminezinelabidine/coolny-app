package com.example.coolnyapp.Models;

public class Commande {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int id;
    public int idProduit ;

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public int qte;




    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }



    public Commande(int id, int idProduit, int qte) {
        this.id =id;
        this.idProduit = idProduit;
        this.qte = qte;
    }

    public Commande() {
    }
}
