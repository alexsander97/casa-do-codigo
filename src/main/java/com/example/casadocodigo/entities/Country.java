package com.example.casadocodigo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;

    @Deprecated
    public Country() {

    }

    public Country(String name) {
        this.name = name;
    }

}
