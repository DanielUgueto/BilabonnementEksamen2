package com.example.bilabonnementeksamen2.models.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Skadesrapport {
    private int rapportID;
    private int lejeaftaleID;
    private LocalDate dato;
    private double totalPris;
    private List<Skade> skader = new ArrayList<>();


    public Skadesrapport(int rapportID, int lejeaftaleID, LocalDate dato, double totalPris) {
        this.rapportID = rapportID;
        this.lejeaftaleID = lejeaftaleID;
        this.dato = dato;
        this.totalPris = totalPris;
    }

    public int getRapportID() {
        return rapportID;
    }
    public void setRapportID(int rapportID) {
        this.rapportID = rapportID;
    }

    public int getLejeaftaleID() {
        return lejeaftaleID;
    }
    public void setLejeaftaleID(int lejeaftaleID) {
        this.lejeaftaleID = lejeaftaleID;
    }

    public LocalDate getDato() {
        return dato;
    }
    public void setDato(LocalDate dato) {
        this.dato = dato;
    }

    public double getTotalPris() {
        return totalPris;
    }
    public void setTotalPris(double totalPris) {
        this.totalPris = totalPris;
    }

    public List<Skade> getSkader() {
        return skader;
    }
    public void addSkade(Skade skade) {
        skader.add(skade);
        totalPris += skade.getPris();
    }
}
