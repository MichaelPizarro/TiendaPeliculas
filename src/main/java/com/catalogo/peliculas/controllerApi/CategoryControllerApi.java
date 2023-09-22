package com.catalogo.peliculas.controllerApi;

import com.catalogo.peliculas.dto.FilmCategoryDTO;
import com.catalogo.peliculas.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryControllerApi {

    final FilmService filmService;

    public CategoryControllerApi(FilmService filmService) {
        this.filmService = filmService;
    }
    @GetMapping("/peliculas")
    public ResponseEntity<List<FilmCategoryDTO>> getAllFilms(
            @RequestParam(value = "categoria", required = false) String categoria,
            @RequestParam(value = "palabraClave", required = false) String palabraClave) {
        return new ResponseEntity<>(filmService.getAllFilms(palabraClave, categoria), HttpStatus.OK);
    }

    // Ejemplo   :   http://localhost:8080/api/peliculas?categoria=Action&palabraClave=anti
}
