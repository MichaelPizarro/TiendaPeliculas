package com.catalogo.peliculas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private int filmId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Column(name = "release_year")
    private Short releaseYear;

    @Column(name = "language_id", nullable = false)
    private int languageId;

    @Column(name = "rental_duration",nullable = false, columnDefinition = "TINYINT UNSIGNED DEFAULT 3")
    private int rentalDuration;

    @Column(name = "rental_rate", nullable = false, columnDefinition = "DECIMAL(4,2) DEFAULT 4.99")
    private Double rentalRate;

    @Column(name = "length")
    private Short length;

    @Column(name = "replacement_cost", nullable = false, columnDefinition = "DECIMAL(5,2) DEFAULT 19.99")
    private Double replacementCost;

    @Column(name = "rating")
    private String rating;

    @Column(name = "special_feature")
    private String specialFeatures;

    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    @OneToMany(mappedBy = "film")
    private List<FilmCategory> filmsCategories;

}
