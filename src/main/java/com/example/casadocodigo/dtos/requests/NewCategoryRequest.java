package com.example.casadocodigo.dtos.requests;

import com.example.casadocodigo.entities.Category;
import com.example.casadocodigo.validation.annotations.UniqueValue;

import javax.validation.constraints.NotBlank;

public class NewCategoryRequest {

    @NotBlank
    @UniqueValue(domainClass = Category.class, fieldName = "name")
    public String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
