package com.github.Radu_A.repaso_ia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.github.Radu_A.repaso_ia.service.ProverbioService;

@Controller
public class HomeController {

    private final ProverbioService proverbioService;

    public HomeController(ProverbioService proverbioService) {
        this.proverbioService = proverbioService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("proverbio", proverbioService.getProverbioAleatorio());
        return "home";
    }

    @GetMapping("/imagenes")
    public String imagenes() {
        return "imagenes";
    }
}
