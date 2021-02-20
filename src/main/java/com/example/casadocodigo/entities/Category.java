package com.example.casadocodigo.entities;

import javax.persistence.*;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Deprecated
    public Category() {

    }

    public Category(String name) {
        this.name = name;
    }
}
