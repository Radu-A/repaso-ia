package com.github.Radu_A.repaso_ia.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.github.Radu_A.repaso_ia.model.Imagen;
import com.github.Radu_A.repaso_ia.repository.ImagenRepository;

@Service
public class ImagenService {

    private final ImagenRepository imagenRepository;

    public ImagenService(ImagenRepository imagenRepository) {
        this.imagenRepository = imagenRepository;
    }

    public List<Imagen> findAll() {
        return imagenRepository.findAll();
    }

    public Optional<Imagen> findById(Long id) {
        return imagenRepository.findById(id);
    }

    public Imagen getImagenAleatoria() {
        List<Imagen> imagenes = imagenRepository.findAll();
        int index = ThreadLocalRandom.current().nextInt(imagenes.size());
        return imagenes.get(index);
    }

    public List<Imagen> getOpcionesIncorrectas(Imagen correcta, int count) {
        List<Imagen> todas = imagenRepository.findAll();
        List<Imagen> otras = new ArrayList<>();
        for (Imagen img : todas) {
            if (!img.getId().equals(correcta.getId())) {
                otras.add(img);
            }
        }
        Collections.shuffle(otras, ThreadLocalRandom.current());
        return otras.subList(0, Math.min(count, otras.size()));
    }
}
