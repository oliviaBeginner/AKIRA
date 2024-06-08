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
import entite.Article;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {
    
    // Create
    public static int createArticle(Article article) throws SQLException {
        int retour = 0;
        Connection con = Connexion.Connect();
        String insertSql = "INSERT INTO article(id, libelle, prix, quantite_en_stock, date_creation, quantite_seuil, categorie_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(insertSql);
        ps.setInt(1, article.getId());
        ps.setString(2, article.getLibelle());
        ps.setDouble(3, article.getPrix());
        ps.setInt(4, article.getQuantiteEnStock());
        ps.setDate(5, new java.sql.Date(article.getDateCreation().getTime()));
        ps.setInt(6, article.getQuantiteSeuil());
        ps.setInt(7, article.getCategorieId());
        retour = ps.executeUpdate();
        return retour;
    }

    // Read
    public static Article readArticle(int id) throws SQLException {
        Article article = null;
        Connection con = Connexion.Connect();
        String searchSql = "SELECT * FROM article WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(searchSql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            article = new Article(rs.getInt("id"), rs.getString("libelle"), rs.getDouble("prix"), rs.getInt("quantite_en_stock"), rs.getDate("date_creation"), rs.getInt("quantite_seuil"), rs.getInt("categorie_id"));
        }
        return article;
    }

    // Update
    public static int updateArticle(Article article) throws SQLException {
        int retour = 0;
        Connection con = Connexion.Connect();
        String updateSql = "UPDATE article SET libelle = ?, prix = ?, quantite_en_stock = ?, date_creation = ?, quantite_seuil = ?, categorie_id = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(updateSql);
        ps.setString(1, article.getLibelle());
        ps.setDouble(2, article.getPrix());
        ps.setInt(3, article.getQuantiteEnStock());
        ps.setDate(4, new java.sql.Date(article.getDateCreation().getTime()));
        ps.setInt(5, article.getQuantiteSeuil());
        ps.setInt(6, article.getCategorieId());
        ps.setInt(7, article.getId());
        retour = ps.executeUpdate();
        return retour;
    }

    // Delete
    public static int deleteArticle(int id) throws SQLException {
        int retour = 0;
        Connection con = Connexion.Connect();
        String deleteSql = "DELETE FROM article WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(deleteSql);
        ps.setInt(1, id);
        retour = ps.executeUpdate();
        return retour;
    }

    // Get All Articles
    public static List<Article> getAllArticles() throws SQLException {
        List<Article> articles = new ArrayList<>();
        Connection con = Connexion.Connect();
        String query = "SELECT * FROM article";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Article article = new Article(rs.getInt("id"), rs.getString("libelle"), rs.getDouble("prix"), rs.getInt("quantite_en_stock"), rs.getDate("date_creation"), rs.getInt("quantite_seuil"), rs.getInt("categorie_id"));
            articles.add(article);
        }
        return articles;
    }

    // Get Articles Below Threshold
    public static List<Article> getArticlesBelowThreshold() throws SQLException {
        List<Article> articles = new ArrayList<>();
        Connection con = Connexion.Connect();
        String query = "SELECT * FROM article WHERE quantite_en_stock < quantite_seuil";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Article article = new Article(rs.getInt("id"), rs.getString("libelle"), rs.getDouble("prix"), rs.getInt("quantite_en_stock"), rs.getDate("date_creation"), rs.getInt("quantite_seuil"), rs.getInt("categorie_id"));
            articles.add(article);
        }
        return articles;
    }
}

