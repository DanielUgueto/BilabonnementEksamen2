package com.example.bilabonnementeksamen2.models.entities;

import com.example.bilabonnementeksamen2.models.enums.BilStatus;
import com.example.bilabonnementeksamen2.models.enums.BilDrivstoff;
import com.example.bilabonnementeksamen2.models.enums.BilGeartype;

//nogle attributter er blevet lavet til wrappers så deres placesholders kan blive vist på hjemmesiden istedet for at være udfyldt på forhånd
public class Bil {
    private String vognnummer;
    private String stelnummer;
    private String maerke;
    private String model;
    private Integer antalDoere;
    private Integer antalPersoner;
    private String farve;
    private BilDrivstoff drivstoff;
    private BilGeartype geartype;
    private Integer kmTal;
    private Double kmL;
    private Integer fabriksAar;
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

    public Integer getAntalDoere() {
        return antalDoere;
    }
    public void setAntalDoere(Integer antalDoere) {
        this.antalDoere = antalDoere;
    }

    public Integer getAntalPersoner() {
        return antalPersoner;
    }
    public void setAntalPersoner(Integer antalPersoner) {
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

    public BilGeartype getGeartype() {
        return geartype;
    }
    public void setGeartype(BilGeartype geartype) {
        this.geartype = geartype;
    }

    public Integer getKmTal() {
        return kmTal;
    }
    public void setKmTal(Integer kmTal) {
        this.kmTal = kmTal;
    }

    public Double getKmL() {
        return kmL;
    }
    public void setKmL(Double kmL) {
        this.kmL = kmL;
    }

    public Integer getFabriksAar() {
        return fabriksAar;
    }
    public void setFabriksAar(Integer fabriksAar) {
        this.fabriksAar = fabriksAar;
    }

    public BilStatus getStatus() {
        return status;
    }
    public void setStatus(BilStatus status) {
        this.status = status;
    }
}
