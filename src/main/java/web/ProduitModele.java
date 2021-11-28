package web;

import metier.entities.Produit;

import java.util.ArrayList;
import java.util.List;

public class ProduitModele {
    private String mc;
    private List<Produit> prods = new ArrayList<>();

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public List<Produit> getProds() {
        return prods;
    }

    public void setProds(List<Produit> prods) {
        this.prods = prods;
    }
}
