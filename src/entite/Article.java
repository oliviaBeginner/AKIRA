/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

import java.util.Date;

/**
 *
 * @author olivi
 */
public class Article {

    private int id;
    private String libelle;
    private double prix;
    private int quantiteEnStock;
    private Date dateCreation;
    private int quantiteSeuil;
    private int categorieId;

    /* Constructeur par défaut */
    public Article() {
    }

    public Article(int id, String libelle, double prix, int quantiteEnStock, Date dateCreation, int quantiteSeuil, int categorieId) {
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
        this.quantiteEnStock = quantiteEnStock;
        this.dateCreation = dateCreation;
        this.quantiteSeuil = quantiteSeuil;
        this.categorieId = categorieId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public int getQuantiteSeuil() {
        return quantiteSeuil;
    }

    public void setQuantiteSeuil(int quantiteSeuil) {
        this.quantiteSeuil = quantiteSeuil;
    }

    public int getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(int categorieId) {
        this.categorieId = categorieId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", prix=" + prix +
                ", quantiteEnStock=" + quantiteEnStock +
                ", dateCreation=" + dateCreation +
                ", quantiteSeuil=" + quantiteSeuil +
                ", categorieId=" + categorieId +
                '}';
    }
}


