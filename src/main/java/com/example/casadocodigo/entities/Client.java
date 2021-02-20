package com.example.casadocodigo.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
public class Client {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "EMAIL", unique = true, nullable = false)
    @Email
    private String email;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "CPF_CNPJ", unique = true, nullable = false)
    private String document;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "COMPLEMENT", nullable = false)
    private String complement;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "POSTAL_CODE", nullable = false)
    private String postalCode;

    @ManyToOne
    @JoinColumn(name = "STATE_ID")
    private State state;

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", nullable = false)
    private Country country;

    @Column(name = "PHONE_NUMBER", nullable = false)
    private String phoneNumber;

    @Deprecated
    public Client() {

    }

    public Client(String email, String name, String lastName, String document,
                  String address, String complement, String city, String postalCode,
                  Country country, String phoneNumber) {
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Long getId() {
        return this.id;
    }


}
