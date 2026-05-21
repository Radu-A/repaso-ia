package com.github.Radu_A.repaso_ia.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.Radu_A.repaso_ia.model.Imagen;
import com.github.Radu_A.repaso_ia.service.ImagenService;

@Controller
@RequestMapping("/imagenes")
public class ImagenController {

    private final ImagenService imagenService;

    public ImagenController(ImagenService imagenService) {
        this.imagenService = imagenService;
    }

    @GetMapping("/menu")
    public String menu(Model model) {
        Imagen correcta = imagenService.getImagenAleatoria();
        List<Imagen> incorrectas = imagenService.getOpcionesIncorrectas(correcta, 3);

        List<Imagen> opciones = new ArrayList<>(incorrectas);
        opciones.add(correcta);
        Collections.shuffle(opciones);

        model.addAttribute("imagen", correcta);
        model.addAttribute("opciones", opciones);
        return "imagenes/menú";
    }

    @GetMapping("/respuesta/{idImagen}/{idOpcion}")
    public String respuesta(@PathVariable Long idImagen, @PathVariable Long idOpcion, Model model) {
        boolean acierto = idImagen.equals(idOpcion);
        Imagen imagen = imagenService.findById(idImagen).orElseThrow();

        model.addAttribute("imagen", imagen);
        model.addAttribute("acierto", acierto);

        if (!acierto) {
            imagenService.findById(idOpcion).ifPresent(opcion -> model.addAttribute("elegida", opcion));
        }

        return "imagenes/respuesta";
    }
}
