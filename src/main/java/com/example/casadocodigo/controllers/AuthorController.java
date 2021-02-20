package com.example.casadocodigo.controllers;

import com.example.casadocodigo.dtos.requests.NewAuthorRequest;
import com.example.casadocodigo.entities.Author;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid NewAuthorRequest request){
        Author author = request.toEntity();
        entityManager.persist(author);
    }
}
