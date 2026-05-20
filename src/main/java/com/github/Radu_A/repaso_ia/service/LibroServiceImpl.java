package com.github.Radu_A.repaso_ia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.Radu_A.repaso_ia.model.Genero;
import com.github.Radu_A.repaso_ia.model.Libro;
import com.github.Radu_A.repaso_ia.repository.LibroRepository;

@Service
public class LibroServiceImpl implements ILibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public List<Libro> findByGenero(String genero) {
        Genero g = Genero.valueOf(genero.toUpperCase());
        return libroRepository.findByGenero(g);
    }

    @Override
    public Optional<Libro> findById(Long id) {
        return libroRepository.findById(id);
    }

    @Override
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public void deleteById(Long id) {
        libroRepository.deleteById(id);
    }
}
