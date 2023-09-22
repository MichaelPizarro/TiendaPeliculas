package com.catalogo.peliculas;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AnalizadorTitulosImpl1 implements AnalizadorTitulos{
    @Override
    public Integer analizar(String titulo) {
        String[] palabras = titulo.split(" ");

        int numeroDePalabras = palabras.length;


        if (numeroDePalabras == 1) {
            return -1; // poco atractivo
        } else if (numeroDePalabras == 2) {
            return 0; //  indiferente
        } else {
            return 1; //  atractivo
        }
    }
}
