package com.example.bilabonnementeksamen2.controllers;

import com.example.bilabonnementeksamen2.models.entities.Skade;
import com.example.bilabonnementeksamen2.services.SkadeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/skader")
public class SkadeController {

    private final SkadeService skadeService;

    public SkadeController(SkadeService skadeService) {
        this.skadeService = skadeService;
    }

    @PostMapping("/opret")
    public String opretSkade(@RequestParam int rapportID, @RequestParam String beskrivelse, @RequestParam double pris) {
        skadeService.opretSkade(rapportID, beskrivelse, pris);
        return "redirect:/skadesrapporter/rediger?lejeaftaleID=" + rapportID;
    }
}
