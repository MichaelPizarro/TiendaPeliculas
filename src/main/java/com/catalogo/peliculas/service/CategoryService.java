package com.catalogo.peliculas.service;

import com.catalogo.peliculas.model.Category;
import com.catalogo.peliculas.repository.ICategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService {

    final ICategoryRepository iCategoryRepository;

    public CategoryService(ICategoryRepository iCategoryRepository) {
        this.iCategoryRepository = iCategoryRepository;
    }

    public List<String> getAllCategoriesNames(){

        return iCategoryRepository.findAllCategoriesNames();
    }
}
