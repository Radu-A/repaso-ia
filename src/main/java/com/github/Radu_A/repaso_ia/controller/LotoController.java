package com.github.Radu_A.repaso_ia.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.Radu_A.repaso_ia.service.LotoService;

@Controller
@RequestMapping("/loto")
public class LotoController {

    private final LotoService lotoService;

    public LotoController(LotoService lotoService) {
        this.lotoService = lotoService;
    }

    @GetMapping("/menu")
    public String menu() {
        return "loto-menu";
    }

    @GetMapping("/genera/{max}/{count}/{pais}")
    public String genera(@PathVariable int max, @PathVariable int count, @PathVariable String pais, Model model) {
        List<Integer> combinacion = lotoService.generarCombinacion(max, count);
        String nombrePais = lotoService.getNombrePais(pais);
        model.addAttribute("pais", nombrePais);
        model.addAttribute("combinacion", combinacion);
        model.addAttribute("max", max);
        model.addAttribute("count", count);
        return "loto-genera";
    }
}
