package com.example.casadocodigo.dtos.responses;

import com.example.casadocodigo.entities.Book;

public class BookResponseDto {

    private Long id;

    private String title;


    public BookResponseDto(Book entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }
}
