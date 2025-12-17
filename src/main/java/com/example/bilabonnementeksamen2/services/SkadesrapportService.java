package com.example.bilabonnementeksamen2.services;

import com.example.bilabonnementeksamen2.models.entities.Skadesrapport;
import com.example.bilabonnementeksamen2.models.enums.BilStatus;
import com.example.bilabonnementeksamen2.repositories.BilRepo;
import com.example.bilabonnementeksamen2.repositories.SkadesrapportRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SkadesrapportService {

    private final SkadesrapportRepo repo;
    private final BilRepo bilRepo;

    public SkadesrapportService(SkadesrapportRepo repo, BilRepo bilRepo) {
        this.repo = repo;
        this.bilRepo = bilRepo;
    }

    public void opretSkadesrapport(int lejeaftaleID, String vognnummer) {
        Skadesrapport rapport = new Skadesrapport();
        rapport.setLejeaftaleID(lejeaftaleID);
        rapport.setTotalPris(0);

        repo.save(rapport);
        bilRepo.updateStatus(vognnummer, BilStatus.UNDER_GENNEMGANG);
    }

    public void afslutSkadesrapport(int rapportID, String vognnummer) {
        repo.markAfsluttet(rapportID);
        bilRepo.updateStatus(vognnummer, BilStatus.LEDIG);
    }

//    public Skadesrapport findByLejeaftaleID(int lejeaftaleID) {
//        return repo.findByLejeaftaleID(lejeaftaleID);
//    }

//    public List<Skadesrapport> findKlarTilGennemgang() {
//        return repo.findKlarTilGennemgang();
//    }


}

