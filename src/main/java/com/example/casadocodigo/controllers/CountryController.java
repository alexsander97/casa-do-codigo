package com.example.casadocodigo.controllers;

import com.example.casadocodigo.dtos.requests.NewCountryRequest;
import com.example.casadocodigo.entities.Country;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/country")
public class CountryController {

    @PersistenceContext
    public EntityManager entityManager;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid NewCountryRequest request) {
        Country country = new Country(request.getName());
        entityManager.persist(country);
    }
}
