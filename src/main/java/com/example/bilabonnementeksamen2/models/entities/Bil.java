package com.example.bilabonnementeksamen2.models.entities;

import com.example.bilabonnementeksamen2.models.enums.BilStatus;
import com.example.bilabonnementeksamen2.models.enums.BilDrivstoff;
import com.example.bilabonnementeksamen2.models.enums.BilGeartype;

public class Bil {
    private String vognnummer;
    private String stelnummer;
    private String maerke;
    private String model;
    private int antalDoere;
    private int antalPersoner;
    private String farve;
    private BilDrivstoff drivstoff;
    private BilGeartype geartype;
    private int kmTal;
    private double kmL;
    private int fabriksAar;
    private BilStatus status;

    public Bil() {

        this.vognnummer = vognnummer;
        this.stelnummer = stelnummer;
        this.maerke = maerke;
        this.model = model;
        this.antalDoere = antalDoere;
        this.antalPersoner = antalPersoner;
        this.farve = farve;
        this.drivstoff = drivstoff;
        this.geartype = geartype;
        this.kmTal = kmTal;
        this.kmL = kmL;
        this.fabriksAar = fabriksAar;
        this.status = status;
    }

    public String getVognnummer() {
        return vognnummer;
    }
    public void setVognnummer(String vognnummer) {
        this.vognnummer = vognnummer;
    }

    public String getStelnummer() {
        return stelnummer;
    }
    public void setStelnummer(String stelnummer) {
        this.stelnummer = stelnummer;
    }

    public String getMaerke() {
        return maerke;
    }
    public void setMaerke(String maerke) {
        this.maerke = maerke;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getAntalDoere() {
        return antalDoere;
    }
    public void setAntalDoere(int antalDoere) {
        this.antalDoere = antalDoere;
    }

    public int getAntalPersoner() {
        return antalPersoner;
    }
    public void setAntalPersoner(int antalPersoner) {
        this.antalPersoner = antalPersoner;
    }

    public String getFarve() {
        return farve;
    }
    public void setFarve(String farve) {
        this.farve = farve;
    }

    public BilDrivstoff getDrivstoff() {
        return drivstoff;
    }
    public void setDrivstoff(BilDrivstoff drivstoff) {
        this.drivstoff = drivstoff;
    }

    public BilGeartype getGearType() {
        return geartype;
    }
    public void setGearType(BilGeartype gearType) {
        this.geartype = gearType;
    }

    public int getKmTal() {
        return kmTal;
    }
    public void setKmTal(int kmTal) {
        this.kmTal = kmTal;
    }

    public double getKmL() {
        return kmL;
    }
    public void setKmL(double kmL) {
        this.kmL = kmL;
    }

    public int getFabriksAar() {
        return fabriksAar;
    }
    public void setFabriksAar(int fabriksAar) {
        this.fabriksAar = fabriksAar;
    }

    public BilStatus getStatus() {
        return status;
    }
    public void setStatus(BilStatus status) {
        this.status = status;
    }
}
