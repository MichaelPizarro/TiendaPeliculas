package com.catalogo.peliculas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "film_category")
public class FilmCategory {

    @EmbeddedId
    FilmCategoryKey id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId("filmId")
    @JoinColumn(name = "film_id")
    @JsonIgnore
    private Film film;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    @Column(name = "last_update")
    private Timestamp lastUpdate;
}
