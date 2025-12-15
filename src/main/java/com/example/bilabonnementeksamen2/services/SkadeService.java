package com.example.bilabonnementeksamen2.services;

import com.example.bilabonnementeksamen2.models.entities.Skade;
import com.example.bilabonnementeksamen2.repositories.SkadeRepo;
import com.example.bilabonnementeksamen2.repositories.SkadesrapportRepo;
import org.springframework.stereotype.Service;

@Service
public class SkadeService {

    private final SkadeRepo skadeRepo;
    private final SkadesrapportRepo skadesrapportRepo;

    public SkadeService(SkadeRepo skadeRepo, SkadesrapportRepo skadesrapportRepo) {
        this.skadeRepo = skadeRepo;
        this.skadesrapportRepo = skadesrapportRepo;
    }

    public void registrerSkade(Skade skade) {
        skadeRepo.save(skade);
//        double totalPris = skadesrapportRepo.updateTotalPris(skade.getRapportID());
        skadesrapportRepo.updateTotalPris(skade.getRapportID());
    }

}
