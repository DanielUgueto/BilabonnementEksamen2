package com.example.bilabonnementeksamen2.controllers;

import com.example.bilabonnementeksamen2.models.entities.Bil;
import com.example.bilabonnementeksamen2.models.entities.Lejeaftale;
import com.example.bilabonnementeksamen2.models.enums.BilDrivstoff;
import com.example.bilabonnementeksamen2.models.enums.BilGeartype;
import com.example.bilabonnementeksamen2.models.enums.LejeaftaleAbonnementstype;
import com.example.bilabonnementeksamen2.services.BilService;
import com.example.bilabonnementeksamen2.services.LejeaftaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/lejeaftaler")
public class LejeaftaleController {
    private final LejeaftaleService lejeaftaleService;
    private final BilService bilService;

    public LejeaftaleController(LejeaftaleService lejeaftaleService, BilService bilService) {
        this.lejeaftaleService = lejeaftaleService;
        this.bilService = bilService;
    }

    @GetMapping("/opret")
    public String visOpretLejeaftaleForm(Model model) {
        model.addAttribute("lejeaftale", new Lejeaftale());
        model.addAttribute("abonnementstyper", LejeaftaleAbonnementstype.values());
        model.addAttribute("biler", bilService.hentAlleBiler());
        return "opret-lejeaftale";
    }

    @PostMapping("/opret")
    public String opretLejeaftale(@ModelAttribute Lejeaftale lejeaftale) {
        lejeaftaleService.opretLejeaftale(lejeaftale);
        return "redirect:/";
    }


    @PostMapping("/afslut")
    public String afslutLejeaftale(@RequestParam int lejeaftaleID, @RequestParam String vognnummer) {
        lejeaftaleService.afslutLejeaftale(lejeaftaleID, vognnummer);
        return "redirect:/";
    }

    @GetMapping("/aktive-aftaler")
    public String visLejeaftaler(Model model) {
        model.addAttribute("lejeaftaler", lejeaftaleService.findAll());
        return "lejeaftale-oversigt";
    }

//    @GetMapping("/indtjening")
//    public String visIndtjening(@RequestParam LocalDate fra, @RequestParam LocalDate til, Model model) {
//        double total = lejeaftaleService.beregnSamletIndtaegt(fra, til);
//        model.addAttribute("total", total);
//        return "indtjening";
//    }

}