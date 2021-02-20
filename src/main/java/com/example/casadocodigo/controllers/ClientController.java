package com.example.casadocodigo.controllers;

import com.example.casadocodigo.dtos.requests.NewClientRequest;
import com.example.casadocodigo.dtos.responses.ClientResponseDto;
import com.example.casadocodigo.entities.Client;
import com.example.casadocodigo.validation.validators.CountryWithoutStateValidator;
import com.example.casadocodigo.validation.validators.StateExistsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CountryWithoutStateValidator countryWithoutStateValidator;

    @Autowired
    private StateExistsValidator stateExistsValidator;

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(countryWithoutStateValidator,
                stateExistsValidator);
    }


    @PostMapping
    @Transactional
    public ResponseEntity<ClientResponseDto> create(@RequestBody @Valid NewClientRequest request) {
        Client client = request.toEntity(entityManager);
        entityManager.persist(client);
        return ResponseEntity.ok(new ClientResponseDto(client.getId()));
    }
}
