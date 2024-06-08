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
import entite.Approvisionnement;

public class ApprovisionnementDao {

    // Create
    public static int createApprovisionnement(Approvisionnement approvisionnement) throws SQLException {
        int retour = 0;
        Connection con = Connexion.Connect();
        String insertSql = "INSERT INTO approvisionnement(article_id, quantite, date_approvisionnement) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(insertSql);
        ps.setInt(1, approvisionnement.getArticleId());
        ps.setInt(2, approvisionnement.getQuantite());
        ps.setDate(3, new java.sql.Date(approvisionnement.getDateApprovisionnement().getTime()));
        retour = ps.executeUpdate();
        return retour;
    }

    // Read
    public static Approvisionnement readApprovisionnement(int id) throws SQLException {
        Approvisionnement approvisionnement = null;
        Connection con = Connexion.Connect();
        String searchSql = "SELECT * FROM approvisionnement WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(searchSql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            approvisionnement = new Approvisionnement(
                rs.getInt("id"),
                rs.getInt("article_id"),
                rs.getInt("quantite"),
                rs.getDate("date_approvisionnement")
            );
        }
        return approvisionnement;
    }

    // Update
    public static int updateApprovisionnement(Approvisionnement approvisionnement) throws SQLException {
        int retour = 0;
        Connection con = Connexion.Connect();
        String updateSql = "UPDATE approvisionnement SET article_id = ?, quantite = ?, date_approvisionnement = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(updateSql);
        ps.setInt(1, approvisionnement.getArticleId());
        ps.setInt(2, approvisionnement.getQuantite());
        ps.setDate(3, new java.sql.Date(approvisionnement.getDateApprovisionnement().getTime()));
        ps.setInt(4, approvisionnement.getId());
        retour = ps.executeUpdate();
        return retour;
    }

    // Delete
    public static int deleteApprovisionnement(int id) throws SQLException {
        int retour = 0;
        Connection con = Connexion.Connect();
        String deleteSql = "DELETE FROM approvisionnement WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(deleteSql);
        ps.setInt(1, id);
        retour = ps.executeUpdate();
        return retour;
    }

    // Get All Approvisionnements
    public static List<Approvisionnement> getAllApprovisionnements() throws SQLException {
        List<Approvisionnement> approvisionnements = new ArrayList<>();
        Connection con = Connexion.Connect();
        String query = "SELECT * FROM approvisionnement";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Approvisionnement approvisionnement = new Approvisionnement(
                rs.getInt("id"),
                rs.getInt("article_id"),
                rs.getInt("quantite"),
                rs.getDate("date_approvisionnement")
            );
            approvisionnements.add(approvisionnement);
        }
        return approvisionnements;
    }
}

