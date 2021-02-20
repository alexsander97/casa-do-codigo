package com.example.casadocodigo.dtos.requests;

import com.example.casadocodigo.entities.Author;
import com.example.casadocodigo.validation.annotations.UniqueValue;

import javax.validation.constraints.*;


public class NewAuthorRequest {

    @NotBlank
    public String name;
    @NotBlank
    @Email
    @UniqueValue(domainClass = Author.class, fieldName = "email")
    public String email;
    @NotBlank
    @Size(max = 400)
    public String description;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author toEntity() {
        return new Author(this.name, this.email, this.description);
    }


}
