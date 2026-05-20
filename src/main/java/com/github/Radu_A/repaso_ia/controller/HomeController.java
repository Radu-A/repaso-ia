package com.github.Radu_A.repaso_ia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/loto")
    public String loto() {
        return "loto";
    }

    @GetMapping("/libros")
    public String libros() {
        return "libros";
    }

    @GetMapping("/imagenes")
    public String imagenes() {
        return "imagenes";
    }
}
