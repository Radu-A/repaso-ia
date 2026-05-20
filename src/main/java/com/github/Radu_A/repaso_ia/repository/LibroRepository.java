package com.github.Radu_A.repaso_ia.repository;

import java.util.List;

import com.github.Radu_A.repaso_ia.model.Genero;
import com.github.Radu_A.repaso_ia.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByGenero(Genero genero);
}
