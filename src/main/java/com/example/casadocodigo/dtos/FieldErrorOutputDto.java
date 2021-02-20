package com.example.casadocodigo.dtos;

public class FieldErrorOutputDto {

    private String field;

    private String message;

    FieldErrorOutputDto(){

    }

    public FieldErrorOutputDto(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
