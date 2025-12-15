package com.example.bilabonnementeksamen2.models.entities;

public class Skade {
    private int skadeID;
    private int rapportID;
    private String beskrivelse;
    private double pris;

    public Skade() {}

    public Skade(int skadeID, int rapportID, String beskrivelse, double pris) {
        this.skadeID = skadeID;
        this.rapportID = rapportID;
        this.beskrivelse = beskrivelse;
        this.pris = pris;
    }

    public int getSkadeID() {
        return skadeID;
    }
    public void setSkadeID(int skadeID) {
        this.skadeID = skadeID;
    }

    public int getRapportID() {
        return rapportID;
    }
    public void setRapportID(int rapportID) {
        this.rapportID = rapportID;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }
    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public double getPris() {
        return pris;
    }
    public void setPris(double pris) {
        this.pris = pris;
    }
}
