package com.github.Radu_A.repaso_ia.service;

import java.util.List;
import java.util.Optional;

import com.github.Radu_A.repaso_ia.model.Libro;

public interface ILibroService {
    List<Libro> findAll();
    List<Libro> findByGenero(String genero);
    Optional<Libro> findById(Long id);
    Libro save(Libro libro);
    void deleteById(Long id);
}
