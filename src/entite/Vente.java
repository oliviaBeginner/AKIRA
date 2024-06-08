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
public class Vente {
    private int id;
    private int articleId;
    private int quantite;
    private Date dateVente;

    /* Constructeur par défaut */
    public Vente() {
    }

    public Vente(int id, int articleId, int quantite, Date dateVente) {
        this.id = id;
        this.articleId = articleId;
        this.quantite = quantite;
        this.dateVente = dateVente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    @Override
    public String toString() {
        return "Vente{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", quantite=" + quantite +
                ", dateVente=" + dateVente +
                '}';
    }
}
