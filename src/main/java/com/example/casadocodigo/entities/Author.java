package com.example.casadocodigo.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "DESCRIPTION", length = 400,  nullable = false)
    private String description;

    @Column(name = "CREATION_DATE", nullable = false)
    private LocalDateTime creationDate = LocalDateTime.now();

    @Deprecated
    public Author() {

    }

    public Author(@NotBlank String name, @NotBlank @Email String email,
                  @NotBlank @Size(max = 400) String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
