package com.catalogo.peliculas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FilmCategoryDTO {

    private String name;
    private int filmId;
    private String title;
    private Short length;
    private String rating;
    private Double rentalRate;
    private int rentalDuration;
}
