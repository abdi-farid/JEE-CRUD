package dao;

import metier.entities.Produit;

import java.util.List;

public interface IProduitDao {
    Produit save(Produit p);
    List<Produit> produitParMc(String mc);
    Produit getProduit(int id);
    Produit updateProduit(Produit p);
    void deleteProduit(int id);
}
