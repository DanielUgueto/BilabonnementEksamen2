package com.example.bilabonnementeksamen2.controllers;

import com.example.bilabonnementeksamen2.models.entities.Bil;
import com.example.bilabonnementeksamen2.models.entities.Skadesrapport;
import com.example.bilabonnementeksamen2.models.enums.BilStatus;
import com.example.bilabonnementeksamen2.services.SkadesrapportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;


@Controller
@RequestMapping("/skadesrapporter")
public class SkadesrapportController {

    private final SkadesrapportService skadesrapportService;

    public SkadesrapportController(SkadesrapportService skadesrapportService) {
        this.skadesrapportService = skadesrapportService;
    }

    @GetMapping("/opret")
    public String visOpretForm(@RequestParam int lejeaftaleID, @RequestParam String vognnummer, Model model) {
        Skadesrapport rapport = new Skadesrapport();
        rapport.setLejeaftaleID(lejeaftaleID);
        model.addAttribute("rapport", rapport);
        model.addAttribute("vognnummer", vognnummer);
        return "opret-skadesrapport";
    }

    @PostMapping("/opret")
    public String opretSkadesrapport(@RequestParam int lejeaftaleID, @RequestParam String vognnummer) {
        skadesrapportService.opretSkadesrapport(lejeaftaleID, vognnummer);
        return "redirect:/skadesrapporter/rediger?lejeaftaleID=" + lejeaftaleID;
    }

    @PostMapping("/afslut")
    public String afslutSkadesrapport (@RequestParam int rapportID, @RequestParam String vognnummer) {
        skadesrapportService.afslutSkadesrapport(rapportID, vognnummer);
        return "redirect:/inspektoer";
    }
//    public List<Bil> findKlarTilGennemgang() {
//        return bilRepo.findByStatus(BilStatus.KLAR_TIL_GENNEMGANG);
//    }
}


