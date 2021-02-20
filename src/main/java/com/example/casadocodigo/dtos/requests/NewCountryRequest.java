package com.example.casadocodigo.dtos.requests;

import com.example.casadocodigo.entities.Country;
import com.example.casadocodigo.validation.annotations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NewCountryRequest {

    @NotBlank
    @UniqueValue(domainClass = Country.class, fieldName = "name")
    private String name;

    public String getName() {
        return name;
    }
}
