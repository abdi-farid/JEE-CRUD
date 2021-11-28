package metier.entities;

import java.io.Serializable;

public class Produit implements Serializable {
    private int idProduit;
    private String nomProduit;
    private double prix;

    public Produit() {
        super();
    }

    public Produit(String nomProduit, double prix) {
        this.nomProduit = nomProduit;
        this.prix = prix;
    }

    public Produit(int idProduit, String nomProduit, double prix) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prix = prix;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
