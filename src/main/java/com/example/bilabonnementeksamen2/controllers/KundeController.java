package com.example.bilabonnementeksamen2.controllers;

import com.example.bilabonnementeksamen2.models.entities.Kunde;
import com.example.bilabonnementeksamen2.services.KundeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kunder")
public class KundeController {

    private final KundeService kundeService;

    public KundeController(KundeService kundeService) {
        this.kundeService = kundeService;
    }

    @GetMapping("/opret")
    public String visOpretKundeForm(Model model) {
        model.addAttribute("kunde", new Kunde());
        return "opret-kunde";
    }

    @PostMapping("/opret")
    public String opretKunde(@ModelAttribute Kunde kunde) {
        kundeService.opretKunde(kunde);
        return "redirect:/";
    }

    @GetMapping("/oversigt")
    public String visKundeOversigt(Model model) {
        model.addAttribute("kunder", kundeService.hentAlleKunder());
        return "kunde-oversigt";
    }

}
