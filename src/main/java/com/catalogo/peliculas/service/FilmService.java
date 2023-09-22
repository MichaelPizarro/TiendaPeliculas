package com.catalogo.peliculas.service;

import com.catalogo.peliculas.dto.FilmCategoryDTO;
import com.catalogo.peliculas.repository.IFilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {

    final IFilmRepository iFilmRepository;

    public FilmService(IFilmRepository iFilmRepository) {
        this.iFilmRepository = iFilmRepository;
    }

    public List<com.catalogo.peliculas.dto.FilmCategoryDTO> getAllFilms(String palabraClave,String categoria){
        if(categoria != null && palabraClave.equals("")){
            return iFilmRepository.findAllFilmByCategory(categoria);
        }

        if (palabraClave != null && categoria.equals("")) {
            return iFilmRepository.findAllFilmByTitle(palabraClave);
        }

        if(categoria != null && palabraClave != null){
            return iFilmRepository.findAllFilmByTitleAndCategory(palabraClave,categoria);
        }

        return iFilmRepository.findAllFilms();
    }
}
