package com.catalogo.peliculas.repository;

import com.catalogo.peliculas.dto.FilmCategoryDTO;
import com.catalogo.peliculas.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFilmRepository extends JpaRepository<Film, Integer> {
    @Query("SELECT NEW com.catalogo.peliculas.dto.FilmCategoryDTO(c.name, f.filmId, f.title, f.length, f.rating, f.rentalRate, f.rentalDuration) FROM Film f " +
            "INNER JOIN f.filmsCategories fc " +
            "INNER JOIN fc.category c")
    List<com.catalogo.peliculas.dto.FilmCategoryDTO> findAllFilms();

    @Query("SELECT NEW com.catalogo.peliculas.dto.FilmCategoryDTO(c.name, f.filmId, f.title, f.length, f.rating, f.rentalRate, f.rentalDuration) " +
            "FROM Film f " +
            "INNER JOIN f.filmsCategories fc " +
            "INNER JOIN fc.category c " +
            "WHERE c.name = :categoria")
    List<com.catalogo.peliculas.dto.FilmCategoryDTO> findAllFilmByCategory(@Param("categoria") String categoria);

    @Query("SELECT NEW com.catalogo.peliculas.dto.FilmCategoryDTO(c.name, f.filmId, f.title, f.length, f.rating, f.rentalRate, f.rentalDuration) " +
            "FROM Film f " +
            "INNER JOIN f.filmsCategories fc " +
            "INNER JOIN fc.category c " +
            "WHERE f.title LIKE %:palabraClave%")
    List<com.catalogo.peliculas.dto.FilmCategoryDTO> findAllFilmByTitle(@Param("palabraClave") String palabraClave);

    @Query("SELECT NEW com.catalogo.peliculas.dto.FilmCategoryDTO(c.name, f.filmId, f.title, f.length, f.rating, f.rentalRate, f.rentalDuration) " +
            "FROM Film f " +
            "INNER JOIN f.filmsCategories fc " +
            "INNER JOIN fc.category c " +
            "WHERE f.title LIKE %:palabraClave% AND c.name = :categoria")
    List<com.catalogo.peliculas.dto.FilmCategoryDTO> findAllFilmByTitleAndCategory(@Param("palabraClave") String palabraClave, @Param("categoria") String categoria);


}


