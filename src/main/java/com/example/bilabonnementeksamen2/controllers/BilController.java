package com.example.bilabonnementeksamen2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.bilabonnementeksamen2.models.entities.Bil;
import com.example.bilabonnementeksamen2.models.enums.BilDrivstoff;
import com.example.bilabonnementeksamen2.models.enums.BilGeartype;
import com.example.bilabonnementeksamen2.services.BilService;

@Controller
@RequestMapping("/biler")
public class BilController {

    private final BilService bilService;

    public BilController(BilService bilService) {
        this.bilService = bilService;
    }

    @GetMapping("/opret")
    public String visOpretBilForm(Model model) {
        model.addAttribute("bil", new Bil());
        model.addAttribute("drivstoff", BilDrivstoff.values());
        model.addAttribute("geartype", BilGeartype.values());
        return "opret-bil";
    }


    @PostMapping("/opret")
    public String opretBil(@ModelAttribute Bil bil) {
        bilService.opretBil(bil);
        return "redirect:/biler";
    }

    @GetMapping
    public String visBilOversigt(Model model) {
        model.addAttribute("biler", bilService.hentAlleBiler());
        return "bil-oversigt";
    }

}
