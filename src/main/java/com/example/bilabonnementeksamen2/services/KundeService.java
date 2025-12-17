package com.example.bilabonnementeksamen2.services;

import com.example.bilabonnementeksamen2.models.entities.Kunde;
import com.example.bilabonnementeksamen2.repositories.KundeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KundeService {

    private final KundeRepo kundeRepo;

    public KundeService(KundeRepo kundeRepo) {
        this.kundeRepo = kundeRepo;
    }

    public void opretKunde(Kunde kunde) {
        kundeRepo.save(kunde);
    }

    public List<Kunde> hentAlleKunder() {
        return kundeRepo.findAll();
    }
}
