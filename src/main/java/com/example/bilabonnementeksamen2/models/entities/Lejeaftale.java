package com.example.bilabonnementeksamen2.models.entities;

import com.example.bilabonnementeksamen2.models.enums.LejeaftaleAbonnementstype;

import java.time.LocalDate;

public class Lejeaftale {
    private int lejeaftaleID;
    private int kundeID;
    private String vognnummer;
    private LocalDate startDato;
    private LocalDate slutDato;
    private LejeaftaleAbonnementstype abonnementstype;
    private Double maanedligPris;
    private boolean aktiv;


    public Lejeaftale() {

        this.lejeaftaleID = lejeaftaleID;
        this.kundeID = kundeID;
        this.vognnummer = vognnummer;
        this.startDato = startDato;
        this.slutDato = slutDato;
        this.abonnementstype = abonnementstype;
        this.maanedligPris = maanedligPris;
        this.aktiv = aktiv;
    }

    public int getLejeaftaleID() {
        return lejeaftaleID;
    }
    public void setLejeaftaleID(int lejeaftaleID) {
        this.lejeaftaleID = lejeaftaleID;
    }

    public int getKundeID() {
        return kundeID;
    }
    public void setKundeID(int kundeID) {
        this.kundeID = kundeID;
    }

    public String getVognnummer() {
        return vognnummer;
    }
    public void setVognnummer(String vognnummer) {
        this.vognnummer = vognnummer;
    }

    public LocalDate getStartDato() {
        return startDato;
    }
    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }
    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    public LejeaftaleAbonnementstype getAbonnementstype() {
        return abonnementstype;
    }
    public void setAbonnementstype(LejeaftaleAbonnementstype abonnementstype) {
        this.abonnementstype = abonnementstype;
    }

    public Double getMaanedligPris() {
        return maanedligPris;
    }
    public void setMaanedligPris(Double maanedligPris) {
        this.maanedligPris = maanedligPris;
    }

    public boolean isAktiv() {
        return aktiv;
    }
    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }
}
