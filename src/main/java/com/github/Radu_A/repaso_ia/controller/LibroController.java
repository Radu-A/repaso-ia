package com.github.Radu_A.repaso_ia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.Radu_A.repaso_ia.model.Genero;
import com.github.Radu_A.repaso_ia.model.Libro;
import com.github.Radu_A.repaso_ia.service.ILibroService;

@Controller
@RequestMapping("/libros")
public class LibroController {

    private final ILibroService libroService;

    public LibroController(ILibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        model.addAttribute("libros", libroService.findAll());
        return "libros-menu";
    }

    @GetMapping("/filtro/{genero}")
    public String filtro(@PathVariable String genero, Model model) {
        model.addAttribute("libros", libroService.findByGenero(genero));
        model.addAttribute("genero", genero);
        return "libros-filtro";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("libro", new Libro());
        model.addAttribute("generos", Genero.values());
        return "libros-nuevo";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        return libroService.findById(id)
                .map(libro -> {
                    model.addAttribute("libro", libro);
                    model.addAttribute("generos", Genero.values());
                    return "libros-nuevo";
                })
                .orElse("redirect:/libros/menu");
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        libroService.deleteById(id);
        return "redirect:/libros/menu";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Libro libro) {
        libroService.save(libro);
        return "redirect:/libros/menu";
    }

    @GetMapping("/{id}")
    public String detalle(@PathVariable Long id, Model model) {
        return libroService.findById(id)
                .map(libro -> {
                    model.addAttribute("libro", libro);
                    return "libros-detalle";
                })
                .orElse("redirect:/libros/menu");
    }
}
