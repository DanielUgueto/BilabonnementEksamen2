package com.example.bilabonnementeksamen2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/administrator")
    public String administrator() {
        return "administrator";
    }

    @GetMapping("/inspektoer")
    public String inspektoer() {
        return "inspektoer";
    }

    @GetMapping("/forretningsudvikler")
    public String forretningsudvikler() {
        return "forretningsudvikler";
    }
}