/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author olivi
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import entite.Categorie;

public class CategorieDao {

    // Create
    public static int createCategorie(Categorie categorie) throws SQLException {
        int retour = 0;
        Connection con = Connexion.Connect();
        String insertCategorieSql = "INSERT INTO categorie(designation) VALUES (?)";
        PreparedStatement ps = con.prepareStatement(insertCategorieSql);
        ps.setString(1, categorie.getDesignation());
        retour = ps.executeUpdate();
        return retour;
    }

    // Read
    public static Categorie readCategorie(int id) throws SQLException {
        Categorie categorie = null;
        Connection con = Connexion.Connect();
        String searchSql = "SELECT * FROM categorie WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(searchSql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            categorie = new Categorie(
                rs.getInt("id"),
                rs.getString("designation")
            );
        }
        return categorie;
    }

    // Update
    public static int updateCategorie(Categorie categorie) throws SQLException {
        int retour = 0;
        Connection con = Connexion.Connect();
        String updateSql = "UPDATE categorie SET designation = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(updateSql);
        ps.setString(1, categorie.getDesignation());
        ps.setInt(2, categorie.getId());
        retour = ps.executeUpdate();
        return retour;
    }

    // Delete
    public static int deleteCategorie(int id) throws SQLException {
        int retour = 0;
        Connection con = Connexion.Connect();
        String deleteSql = "DELETE FROM categorie WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(deleteSql);
        ps.setInt(1, id);
        retour = ps.executeUpdate();
        return retour;
    }

    // Get All Categories
    public static List<Categorie> getAllCategories() throws SQLException {
        List<Categorie> categories = new ArrayList<>();
        Connection con = Connexion.Connect();
        String query = "SELECT * FROM categorie";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Categorie categorie = new Categorie(
                rs.getInt("id"),
                rs.getString("designation")
            );
            categories.add(categorie);
        }
        return categories;
    }
}
