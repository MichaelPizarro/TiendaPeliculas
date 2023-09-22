package com.catalogo.peliculas;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AnalizadorTitulosImpl2 implements AnalizadorTitulos{
    @Override
    public Integer analizar(String titulo) {
        titulo = titulo.toLowerCase();

        int contadorVocales = 0;

        for (int i = 0; i < titulo.length(); i++) {
            char caracter = titulo.charAt(i);
            if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
                contadorVocales++;
            }
        }

        if (contadorVocales < 8) {
            return -1; // poco atractivo
        } else if (contadorVocales >= 9 && contadorVocales <= 12) {
            return 0; //  indiferente
        } else {
            return 1; //  atractivo
        }
    }
}
