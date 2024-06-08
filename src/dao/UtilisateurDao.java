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
import entite.Utilisateur;

public class UtilisateurDao {

    // Create
    public static int createUser(Utilisateur user) throws SQLException {
        int retour = 0;
        Connection con = Connexion.Connect();
        String insertUserSql = "INSERT INTO utilisateur(nom_utilisateur, mot_de_passe) VALUES (?, ?)";
        PreparedStatement ps = con.prepareStatement(insertUserSql);
        ps.setString(1, user.getNomUtilisateur());
        ps.setString(2, user.getMotDePasse());
        retour = ps.executeUpdate();
        return retour;
    }

    // Read
    public static Utilisateur readUser(int id) throws SQLException {
        Utilisateur user = null;
        Connection con = Connexion.Connect();
        String searchSql = "SELECT * FROM utilisateur WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(searchSql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            user = new Utilisateur(
                rs.getInt("id"),
                rs.getString("nom_utilisateur"),
                rs.getString("mot_de_passe")
            );
        }
        return user;
    }

    // Update
    public static int updateUser(Utilisateur user) throws SQLException {
        int retour = 0;
        Connection con = Connexion.Connect();
        String updateSql = "UPDATE utilisateur SET nom_utilisateur = ?, mot_de_passe = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(updateSql);
        ps.setString(1, user.getNomUtilisateur());
        ps.setString(2, user.getMotDePasse());
        ps.setInt(3, user.getId());
        retour = ps.executeUpdate();
        return retour;
    }

    // Delete
    public static int deleteUser(int id) throws SQLException {
        int retour = 0;
        Connection con = Connexion.Connect();
        String deleteSql = "DELETE FROM utilisateur WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(deleteSql);
        ps.setInt(1, id);
        retour = ps.executeUpdate();
        return retour;
    }

    // Get All Users
    public static List<Utilisateur> getAllUsers() throws SQLException {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        Connection con = Connexion.Connect();
        String query = "SELECT * FROM utilisateur";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Utilisateur user = new Utilisateur(
                rs.getInt("id"),
                rs.getString("nom_utilisateur"),
                rs.getString("mot_de_passe")
            );
            utilisateurs.add(user);
        }
        return utilisateurs;
    }

    // Verif Nom Utilisateur
    public static boolean verifNomUtilisateur(String nomUtilisateur) throws SQLException {
        boolean retour = false;
        Connection con = Connexion.Connect();
        String searchSql = "SELECT * FROM utilisateur WHERE nom_utilisateur = ?";
        PreparedStatement ps = con.prepareStatement(searchSql);
        ps.setString(1, nomUtilisateur);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            retour = true;
        }
        return retour;
    }
}
