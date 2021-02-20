package com.example.casadocodigo.dtos.responses;

import com.example.casadocodigo.entities.Author;

public class AuthorDetailsResponse {

    private String name;

    private String description;


    public AuthorDetailsResponse(Author author) {
        this.name = author.getName();
        this.description = author.getDescription();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
