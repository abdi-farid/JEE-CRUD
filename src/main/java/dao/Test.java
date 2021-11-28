package dao;

import metier.entities.Produit;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        IProduitDao dao = new IProduitImpl();

        /*dao.save(new Produit("Test2Save", 1245000));*/

        /*List<Produit> l = dao.produitParMc("est");
        for(Produit p: l){
            System.out.println(p.getIdProduit()+"-"+p.getNomProduit()+"-"+p.getPrix()+" $");
        }*/

        System.out.println(dao.getProduit(2).getIdProduit()+" - "+dao.getProduit(2).getNomProduit());
    }
}
