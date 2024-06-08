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
import entite.Vente;
import java.util.ArrayList;
import java.util.List;

public class VenteDao {
    
    // Create
    public static int createVente(Vente vente) throws SQLException {
        int retour = 0;
        Connection con = Connexion.Connect();
        String insertSql = "INSERT INTO vente(id, article_id, quantite, date_vente) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(insertSql);
        ps.setInt(1, vente.getId());
        ps.setInt(2, vente.getArticleId());
        ps.setInt(3, vente.getQuantite());
        ps.setDate(4, new java.sql.Date(vente.getDateVente().getTime()));
        retour = ps.executeUpdate();
        return retour;
    }

    // Read
    public static Vente readVente(int id) throws SQLException {
        Vente vente = null;
        Connection con = Connexion.Connect();
        String searchSql = "SELECT * FROM vente WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(searchSql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            vente = new Vente(rs.getInt("id"), rs.getInt("article_id"), rs.getInt("quantite"), rs.getDate("date_vente"));
        }
        return vente;
    }

    // Update
    public static int updateVente(Vente vente) throws SQLException {
        int retour = 0;
        Connection con = Connexion.Connect();
        String updateSql = "UPDATE vente SET article_id = ?, quantite = ?, date_vente = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(updateSql);
        ps.setInt(1, vente.getArticleId());
        ps.setInt(2, vente.getQuantite());
        ps.setDate(3, new java.sql.Date(vente.getDateVente().getTime()));
        ps.setInt(4, vente.getId());
        retour = ps.executeUpdate();
        return retour;
    }

    // Delete
    public static int deleteVente(int id) throws SQLException {
        int retour = 0;
        Connection con = Connexion.Connect();
        String deleteSql = "DELETE FROM vente WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(deleteSql);
        ps.setInt(1, id);
        retour = ps.executeUpdate();
        return retour;
    }

    // Get All Ventes
    public static List<Vente> getAllVentes() throws SQLException {
        List<Vente> ventes = new ArrayList<>();
        Connection con = Connexion.Connect();
        String query = "SELECT * FROM vente";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Vente vente = new Vente(rs.getInt("id"), rs.getInt("article_id"), rs.getInt("quantite"), rs.getDate("date_vente"));
            ventes.add(vente);
        }
        return ventes;
    }
}
