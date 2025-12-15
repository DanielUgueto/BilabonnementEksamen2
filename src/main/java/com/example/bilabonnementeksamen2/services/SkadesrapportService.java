package com.example.bilabonnementeksamen2.services;

import com.example.bilabonnementeksamen2.models.entities.Skadesrapport;
import com.example.bilabonnementeksamen2.models.enums.BilStatus;
import com.example.bilabonnementeksamen2.repositories.BilRepo;
import com.example.bilabonnementeksamen2.repositories.SkadesrapportRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SkadesrapportService {

    private final SkadesrapportRepo skadesrapportRepo;
    private final BilRepo bilRepo;

    public SkadesrapportService(SkadesrapportRepo skadesrapportRepo, BilRepo bilRepo) {
        this.skadesrapportRepo = skadesrapportRepo;
        this.bilRepo = bilRepo;
    }

    public void opretSkadesrapport(Skadesrapport rapport, String vognnummer) {
        rapport.setDato(LocalDate.now());
        rapport.setTotalPris(0.0);
        skadesrapportRepo.save(rapport);
        bilRepo.updateStatus(vognnummer, BilStatus.UNDER_GENNEMGANG);
    }

    public void afslutSkadesrapport(int rapportID, String vognnummer) {
        bilRepo.updateStatus(vognnummer, BilStatus.LEDIG);
    }

}
