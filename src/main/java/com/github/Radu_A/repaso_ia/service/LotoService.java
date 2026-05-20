package com.github.Radu_A.repaso_ia.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

@Service
public class LotoService {

    public List<Integer> generarCombinacion(int max, int count) {
        if (count > max || count < 1) {
            throw new IllegalArgumentException("count debe estar entre 1 y max");
        }
        List<Integer> numeros = new ArrayList<>();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        while (numeros.size() < count) {
            int num = random.nextInt(1, max + 1);
            if (!numeros.contains(num)) {
                numeros.add(num);
            }
        }
        Collections.sort(numeros);
        return numeros;
    }

    public String getNombrePais(String pais) {
        return switch (pais.toLowerCase()) {
            case "spain" -> "España";
            case "germany" -> "Alemania";
            case "france" -> "Francia";
            case "italy" -> "Italia";
            default -> pais;
        };
    }
}
