package com.example.bilabonnementeksamen2.services;

import com.example.bilabonnementeksamen2.models.entities.Skade;
import com.example.bilabonnementeksamen2.repositories.SkadeRepo;
import com.example.bilabonnementeksamen2.repositories.SkadesrapportRepo;
import org.springframework.stereotype.Service;

@Service
public class SkadeService {

    private final SkadeRepo skadeRepo;
    private final SkadesrapportRepo rapportRepo;

    public SkadeService(SkadeRepo skadeRepo, SkadesrapportRepo rapportRepo) {
        this.skadeRepo = skadeRepo;
        this.rapportRepo = rapportRepo;
    }

    public void opretSkade(int rapportID, String beskrivelse, double pris) {
        skadeRepo.save(rapportID, beskrivelse, pris);
        rapportRepo.opdaterTotalPris(rapportID, pris);
    }
}
