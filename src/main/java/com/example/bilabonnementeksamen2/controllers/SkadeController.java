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

    @GetMapping("/opret")
    public String visForm(@RequestParam int rapportID, Model model) {
        Skade skade = new Skade();
        skade.setRapportID(rapportID);
        model.addAttribute("skade", skade);
        return "opret-skade";
    }

    @PostMapping("/opret")
    public String opretSkade(@ModelAttribute Skade skade) {
        skadeService.registrerSkade(skade);
        return "redirect:/skadesrapporter";
    }
}
