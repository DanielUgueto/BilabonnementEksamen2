package com.example.bilabonnementeksamen2.models.entities;

public class Kunde {
    private int kundeID;
    private Integer koerekortNummer;
    private String cprNummer;
    private String navn;
    private String adresse;
    private String telefon;
    private String email;


    public Kunde() {
        this.kundeID = kundeID;
        this.koerekortNummer = koerekortNummer;
        this.cprNummer = cprNummer;
        this.navn = navn;
        this.adresse = adresse;
        this.telefon = telefon;
        this.email = email;
    }

    public int getKundeID() {
        return kundeID;
    }
    public void setKundeID(int kundeID) {
        this.kundeID = kundeID;
    }

    public Integer getKoerekortNummer() {
        return koerekortNummer;
    }
    public void setKoerekortNummer(Integer koerekortNummer) {
        this.koerekortNummer = koerekortNummer;
    }

    public String getCprNummer() {
        return cprNummer;
    }
    public void setCprNummer(String cprNummer) {
        this.cprNummer = cprNummer;
    }

    public String getNavn() {
        return navn;
    }
    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelefon() {
        return telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
