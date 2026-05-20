package com.github.Radu_A.repaso_ia.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

@Service
public class ProverbioService {

    private final List<String> proverbios = List.of(
            "\"Un viaje de mil millas comienza con un solo paso.\" — Lao Tse",
            "\"El que pregunta es tonto un momento; el que no, tonto para siempre.\" — Proverbio chino",
            "\"No temas avanzar lentamente, teme solo detenerte.\" — Proverbio chino",
            "\"Cuando el sabio señala la luna, el necio mira el dedo.\" — Proverbio chino",
            "\"El mejor momento para plantar un árbol fue hace veinte años. El segundo mejor momento es ahora.\" — Proverbio chino",
            "\"Quien tiene paciencia obtendrá lo que desea.\" — Proverbio chino",
            "\"Una sonrisa te hará ganar diez años más de vida.\" — Proverbio chino",
            "\"Si no quieres que nadie lo sepa, no lo hagas.\" — Proverbio chino",
            "\"El agua hace flotar el barco, pero también puede hundirlo.\" — Proverbio chino",
            "\"Aprender es como remar contra corriente: en cuanto se deja de remar, se retrocede.\" — Proverbio chino"
    );

    public String getProverbioAleatorio() {
        int index = ThreadLocalRandom.current().nextInt(proverbios.size());
        return proverbios.get(index);
    }
}
