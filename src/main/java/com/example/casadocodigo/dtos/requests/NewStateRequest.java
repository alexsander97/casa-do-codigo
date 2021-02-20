package com.example.casadocodigo.dtos.requests;

import com.example.casadocodigo.entities.Country;
import com.example.casadocodigo.entities.State;
import com.example.casadocodigo.validation.annotations.ExistsId;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

public class NewStateRequest {

    @NotBlank
    private String name;

    @ExistsId(domainClass = Country.class, fieldName = "id")
    private Long idCountry;

    public String getName() {
        return name;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public State toEntity(EntityManager entityManager) {
        Country country = entityManager.find(Country.class, idCountry);
        return new State(name, country);
    }
}
