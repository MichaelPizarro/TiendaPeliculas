package com.catalogo.peliculas.repository;

import com.catalogo.peliculas.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "SELECT name FROM category",nativeQuery = true)
    List<String> findAllCategoriesNames();
}
