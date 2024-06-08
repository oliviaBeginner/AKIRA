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
import entite.Recu;

public class RecuDao {

    // Create
    public static int createRecu(Recu recu) throws SQLException {
        int retour = 0;
        Connection con = Connexion.Connect();
        String insertRecuSql = "INSERT INTO recu(vente_id, date, montant) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(insertRecuSql);
        ps.setInt(1, recu.getVenteId());
        ps.setTimestamp(2, recu.getDate());
        ps.setDouble(3, recu.getMontant());
        retour = ps.executeUpdate();
        return retour;
    }

    // Read
    public static Recu readRecu(int id) throws SQLException {
        Recu recu = null;
        Connection con = Connexion.Connect();
        String searchSql = "SELECT * FROM recu WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(searchSql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            recu = new Recu(
                rs.getInt("id"),
                rs.getInt("vente_id"),
                rs.getTimestamp("date"),
                rs.getDouble("montant")
            );
        }
        return recu;
    }

    // Update
    public static int updateRecu(Recu recu) throws SQLException {
        int retour = 0;
        Connection con = Connexion.Connect();
        String updateSql = "UPDATE recu SET vente_id = ?, date = ?, montant = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(updateSql);
        ps.setInt(1, recu.getVenteId());
        ps.setTimestamp(2, recu.getDate());
        ps.setDouble(3, recu.getMontant());
        ps.setInt(4, recu.getId());
        retour = ps.executeUpdate();
        return retour;
    }

    // Delete
    public static int deleteRecu(int id) throws SQLException {
        int retour = 0;
        Connection con = Connexion.Connect();
        String deleteSql = "DELETE FROM recu WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(deleteSql);
        ps.setInt(1, id);
        retour = ps.executeUpdate();
        return retour;
    }

    // Get All Recus
    public static List<Recu> getAllRecus() throws SQLException {
        List<Recu> recus = new ArrayList<>();
        Connection con = Connexion.Connect();
        String query = "SELECT * FROM recu";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Recu recu = new Recu(
                rs.getInt("id"),
                rs.getInt("vente_id"),
                rs.getTimestamp("date"),
                rs.getDouble("montant")
            );
            recus.add(recu);
        }
        return recus;
    }
}
