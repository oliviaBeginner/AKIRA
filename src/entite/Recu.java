/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entite;

import java.util.Date;
import java.sql.Timestamp;

/**
 *
 * @author olivi
 */


public class Recu {
    private int id;
    private int venteId;
    private Timestamp date;
    private double montant;

    // Constructeurs
    public Recu() {}

    public Recu(int id, int venteId, Timestamp date, double montant) {
        this.id = id;
        this.venteId = venteId;
        this.date = date;
        this.montant = montant;
    }

    public Recu(int venteId, Timestamp date, double montant) {
        this.venteId = venteId;
        this.date = date;
        this.montant = montant;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVenteId() {
        return venteId;
    }

    public void setVenteId(int venteId) {
        this.venteId = venteId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
