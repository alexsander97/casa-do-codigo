package com.example.casadocodigo.entities;

import javax.persistence.*;

@Entity
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", nullable = false)
    private Country country;

    @Deprecated
    public State(){

    }

    public State(String name, Country country) {
        this.name = name;
        this.country = country;
    }
}
