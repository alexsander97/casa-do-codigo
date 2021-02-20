package com.example.casadocodigo.entities;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE", nullable = false, unique = true)
    private String title;

    @Column(name = "ABSTRACT", nullable = false, length = 500)
    private String bookAbstract;

    @Column(name = "SUMMARY", nullable = false)
    private String summary;

    @Column(name = "PRICE", nullable = false)
    @Min(20)
    private BigDecimal price;

    @Column(name = "NUMBER_OF_PAGES", nullable = false)
    private Integer numberOfPages;

    @Column(name = "ISBN", nullable = false, unique = true)
    private String isbn;

    @Column(name = "PUBLICATION_DATE", nullable = false)
    @Future
    private LocalDate publicationDate;

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID", nullable = false)
    @NotNull
    private Author author;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "CATEGORY_ID", nullable = false)
    private Category category;

    @Deprecated
    public Book() {

    }

    public Book(String title, String bookAbstract, String summary,
                BigDecimal price, Integer numberOfPages, String isbn, LocalDate publicationDate, Author author, Category category) {
        this.title = title;
        this.bookAbstract = bookAbstract;
        this.summary = summary;
        this.price = price;
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.author = author;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBookAbstract() {
        return bookAbstract;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public Author getAuthor() {
        return author;
    }
}
