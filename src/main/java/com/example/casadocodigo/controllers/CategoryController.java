package com.example.casadocodigo.controllers;

import com.example.casadocodigo.dtos.requests.NewCategoryRequest;
import com.example.casadocodigo.entities.Category;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @PersistenceContext
    public EntityManager entityManager;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid NewCategoryRequest request) {
        Category category = new Category(request.getName());
        entityManager.persist(category);
    }
}
