package com.example.bilabonnementeksamen2.services;

import com.example.bilabonnementeksamen2.models.entities.Lejeaftale;
import com.example.bilabonnementeksamen2.models.enums.BilStatus;
import com.example.bilabonnementeksamen2.repositories.BilRepo;
import com.example.bilabonnementeksamen2.repositories.LejeaftaleRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LejeaftaleService {
    private final LejeaftaleRepo lejeaftaleRepo;
    private final BilRepo bilRepo;

    public LejeaftaleService(LejeaftaleRepo lejeaftaleRepo, BilRepo bilRepo) {
        this.lejeaftaleRepo = lejeaftaleRepo;
        this.bilRepo = bilRepo;
    }

    public void opretLejeaftale(Lejeaftale lejeaftale) {
        lejeaftale.setAktiv(true);
        lejeaftaleRepo.save(lejeaftale);
        bilRepo.updateStatus(lejeaftale.getVognnummer(), BilStatus.UDLEJET);
    }

    public void afslutLejeaftale(int lejeaftaleID, String vognnummer) {
        lejeaftaleRepo.afslutLejeaftale(lejeaftaleID);
        bilRepo.updateStatus(vognnummer, BilStatus.KLAR_TIL_GENNEMGANG);
    }

    public List<Lejeaftale> findAll() {
        return lejeaftaleRepo.findAll();
    }


}
