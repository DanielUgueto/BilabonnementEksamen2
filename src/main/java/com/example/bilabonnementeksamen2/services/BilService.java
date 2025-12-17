package com.example.bilabonnementeksamen2.services;

import com.example.bilabonnementeksamen2.models.entities.Bil;
import com.example.bilabonnementeksamen2.models.enums.BilStatus;
import com.example.bilabonnementeksamen2.repositories.BilRepo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BilService {

    private final BilRepo bilRepo;

    public BilService(BilRepo bilRepo) {
        this.bilRepo = bilRepo;
    }

    public void opretBil(Bil bil) {

        if (bil.getVognnummer() == null || bil.getVognnummer().isBlank()) {
            throw new IllegalArgumentException("Indtast vognnummer");
        }

        if (bilRepo.existsByVognnummer(bil.getVognnummer())) {
            throw new IllegalArgumentException("Vognnummer findes allerede");
        }

        if (bil.getStelnummer() == null || bil.getStelnummer().isBlank()) {
            throw new IllegalArgumentException("Indtast stelnummer");
        }

        if (bilRepo.existsByStelnummer(bil.getStelnummer())) {
            throw new IllegalArgumentException("Stelnummer findes allerede");
        }

        if (bil.getAntalDoere() <= 0) {
            throw new IllegalArgumentException("Antal døre skal være større end 0");
        }

        if (bil.getAntalPersoner() <= 0) {
            throw new IllegalArgumentException("Antal personer skal være større end 0");
        }

        if (bil.getKmTal() < 0) {
            throw new IllegalArgumentException("Km-tal må ikke være negativt");
        }

        if (bil.getDrivstoff() == null) {
            throw new IllegalArgumentException("Vælg drivstoff");
        }

        if (bil.getGeartype() == null) {
            throw new IllegalArgumentException("Vælg geartype");
        }

        bil.setStatus(BilStatus.LEDIG);
        bilRepo.save(bil);
    }

    public List<Bil> hentAlleBiler() {
        return bilRepo.findAll();
    }

    public Map<String, Integer> hentAntalBilerPrStatus() {
        Map<String, Integer> result = new HashMap<>();

        for (BilStatus status : BilStatus.values()) {
            int count = bilRepo.findByStatus(status.name());
            result.put(status.name(), count);
        }
        return result;
    }

}
