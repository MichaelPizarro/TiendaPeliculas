package com.catalogo.peliculas.controller;

import com.catalogo.peliculas.service.CategoryService;
import com.catalogo.peliculas.service.FilmService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {

    final CategoryService categoryService;
    final FilmService filmService;

    public CategoryController(CategoryService categoryService, FilmService filmService) {
        this.categoryService = categoryService;
        this.filmService = filmService;
    }
    @GetMapping("/")
    public String getAllFilms(Model model, @RequestParam(value = "categoria", required = false) String categoria,
                                           @RequestParam(value = "palabraClave", required = false) String palabraClave){


        model.addAttribute("listCategories",categoryService.getAllCategoriesNames());
        model.addAttribute("listFilmsCategories",filmService.getAllFilms(palabraClave,categoria));
        return "index";
    }
}
