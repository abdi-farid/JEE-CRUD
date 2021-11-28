package dao;

import metier.SingletonConnection;
import metier.entities.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IProduitImpl implements IProduitDao{
    @Override
    public Produit save(Produit p) {
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO produits (NOM_PRODUIT, PRIX) VALUES (?,?);");
            ps.setString(1, p.getNomProduit());
            ps.setDouble(2, p.getPrix());
            ps.executeUpdate();

            PreparedStatement ps2 = connection.prepareStatement("SELECT * FROM PRODUITS WHERE ID_PRODUIT IN (SELECT max(ID_PRODUIT) AS MX FROM PRODUITS);");
            ResultSet rs2 = ps2.executeQuery();
            while(rs2.next()){
                p.setIdProduit(rs2.getInt("ID_PRODUIT"));
                p.setNomProduit(rs2.getString("NOM_PRODUIT"));
                p.setPrix(rs2.getDouble("PRIX"));
            }
            ps.close(); ps2.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Produit> produitParMc(String mc) {
        Connection connection = SingletonConnection.getConnection();
        List<Produit> l = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM PRODUITS WHERE NOM_PRODUIT LIKE ?;");
            ps.setString(1, "%"+mc+"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                l.add(new Produit(
                        rs.getInt("ID_PRODUIT"),
                        rs.getString("NOM_PRODUIT"),
                        rs.getDouble("PRIX")));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return l;
    }

    @Override
    public Produit getProduit(int id) {
        Connection connection = SingletonConnection.getConnection();
        Produit p = new Produit();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM PRODUITS WHERE ID_PRODUIT=?;");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                p.setIdProduit(rs.getInt("ID_PRODUIT"));
                p.setNomProduit(rs.getString("NOM_PRODUIT"));
                p.setPrix(rs.getDouble("PRIX"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return p;
    }

    @Override
    public Produit updateProduit(Produit p) {
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE PRODUITS SET NOM_PRODUIT=?, PRIX=? WHERE ID_PRODUIT=?;");
            ps.setString(1, p.getNomProduit());
            ps.setDouble(2, p.getPrix());
            ps.setInt(3, p.getIdProduit());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return getProduit(p.getIdProduit());
    }

    @Override
    public void deleteProduit(int id) {
        Connection connection = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("delete from produits where ID_PRODUIT=?;");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
