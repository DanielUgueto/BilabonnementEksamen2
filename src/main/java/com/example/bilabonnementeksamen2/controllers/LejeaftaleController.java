package com.example.bilabonnementeksamen2.controllers;

import com.example.bilabonnementeksamen2.models.entities.Lejeaftale;
import com.example.bilabonnementeksamen2.models.enums.LejeaftaleAbonnementstype;
import com.example.bilabonnementeksamen2.services.LejeaftaleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/lejeaftaler")
public class LejeaftaleController {

    private final LejeaftaleService lejeaftaleService;

    public LejeaftaleController(LejeaftaleService lejeaftaleService) {
        this.lejeaftaleService = lejeaftaleService;
    }

    @GetMapping("/opret")
    public String visOpretLejeaftaleForm(Model model) {
        model.addAttribute("lejeaftale", new Lejeaftale());
        model.addAttribute("abonnementstyper", LejeaftaleAbonnementstype.values());
        return "opret-lejeaftale";
    }

    @PostMapping("/opret")
    public String opretLejeaftale(@ModelAttribute Lejeaftale lejeaftale) {
        lejeaftaleService.opretLejeaftale(lejeaftale);
        return "redirect:/lejeaftaler";
    }
}
