package com.example.bilabonnementeksamen2.services;

import com.example.bilabonnementeksamen2.models.entities.Lejeaftale;
import com.example.bilabonnementeksamen2.models.enums.BilStatus;
import com.example.bilabonnementeksamen2.repositories.BilRepo;
import com.example.bilabonnementeksamen2.repositories.LejeaftaleRepo;
import org.springframework.stereotype.Service;

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
}
