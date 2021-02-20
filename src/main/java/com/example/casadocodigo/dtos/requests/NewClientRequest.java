package com.example.casadocodigo.dtos.requests;

import com.example.casadocodigo.entities.Client;
import com.example.casadocodigo.entities.Country;
import com.example.casadocodigo.entities.State;
import com.example.casadocodigo.validation.annotations.CpfOrCnpj;
import com.example.casadocodigo.validation.annotations.ExistsId;
import com.example.casadocodigo.validation.annotations.UniqueValue;


import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewClientRequest {

    @NotBlank
    @Email
    @UniqueValue(domainClass = Client.class, fieldName = "email")
    private String email;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank
    @CpfOrCnpj
    @UniqueValue(domainClass = Client.class, fieldName = "document")
    private String document;

    @NotBlank
    private String address;

    @NotBlank
    private String complement;

    @NotBlank
    private String city;

    @NotNull
    @ExistsId(domainClass = Country.class, fieldName = "id")
    private Long idCountry;

    private Long idState;

    @NotBlank
    private String phoneNumber;

    @NotBlank
    private String postalCode;

    public Client toEntity(EntityManager entityManager) {
        Country country = entityManager.find(Country.class, idCountry);
        State state = null;

        Client client = new Client(this.email, this.name, this.lastName, this.document,
                this.address, this.complement, this.city, this.postalCode, country, phoneNumber);

        if (idState != null) {
            state = entityManager.find(State.class, "id");
            client.setState(state);
        }

        return client;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public Long getIdCountry() {
        return idCountry;
    }

    public Long getIdState() {
        return idState;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
