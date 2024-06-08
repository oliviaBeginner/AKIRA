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
public class Approvisionnement {
    private int id;
    private int articleId;
    private int quantite;
    private Date dateApprovisionnement;

    /* Constructeur par défaut */
    public Approvisionnement() {
    }

    public Approvisionnement(int id, int articleId, int quantite, Date dateApprovisionnement) {
        this.id = id;
        this.articleId = articleId;
        this.quantite = quantite;
        this.dateApprovisionnement = dateApprovisionnement;
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

    public Date getDateApprovisionnement() {
        return dateApprovisionnement;
    }

    public void setDateApprovisionnement(Date dateApprovisionnement) {
        this.dateApprovisionnement = dateApprovisionnement;
    }

    @Override
    public String toString() {
        return "Approvisionnement{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", quantite=" + quantite +
                ", dateApprovisionnement=" + dateApprovisionnement +
                '}';
    }
}
