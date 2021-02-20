package com.example.casadocodigo.controllers;

import com.example.casadocodigo.dtos.requests.NewStateRequest;
import com.example.casadocodigo.entities.State;
import com.example.casadocodigo.validation.validators.AvoidDuplicateStateByCountryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/state")
public class StateController {

    @PersistenceContext
    public EntityManager entityManager;

    @Autowired
    private AvoidDuplicateStateByCountryValidator avoidDuplicateStateByCountryValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(avoidDuplicateStateByCountryValidator);
    }

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid NewStateRequest request) {
        State state = request.toEntity(entityManager);
        entityManager.persist(state);
    }

}
