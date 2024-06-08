/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

/**
 *
 * @author olivi
 */
public class Categorie {
    
    private int id;
    private String designation;

    /* Constructeur par défaut */
    public Categorie() {
    }

    public Categorie(int id, String designation) {
        this.id = id;
        this.designation = designation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", designation='" + designation + '\'' +
                '}';
    }
}
