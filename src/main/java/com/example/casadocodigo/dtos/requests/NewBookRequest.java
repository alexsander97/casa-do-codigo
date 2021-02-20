package com.example.casadocodigo.dtos.requests;

import com.example.casadocodigo.entities.Author;
import com.example.casadocodigo.entities.Book;
import com.example.casadocodigo.entities.Category;
import com.example.casadocodigo.validation.annotations.ExistsId;
import com.example.casadocodigo.validation.annotations.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonFormat.*;

public class NewBookRequest {

    @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "title")
    private String title;

    @NotBlank
    @Size(max = 500)
    private String bookAbstract;

    @NotBlank
    private String summary;

    @NotNull
    @Min(20)
    private BigDecimal price;

    @Min(100)
    @NotNull
    private Integer numberOfPages;

    @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "isbn")
    private String isbn;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Future
    @NotNull
    private LocalDate publicationDate;

    @NotNull
    @ExistsId(domainClass = Author.class, fieldName = "id")
    private Long idAuthor;

    @NotNull
    @ExistsId(domainClass = Category.class, fieldName = "id")
    private Long idCategory;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBookAbstract(String bookAbstract) {
        this.bookAbstract = bookAbstract;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setIdAuthor(Long idAuthor) {
        this.idAuthor = idAuthor;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public Book toEntity(EntityManager entityManager) {
        @NotNull Author author = entityManager.find(Author.class, idAuthor);
        @NotNull Category category = entityManager.find(Category.class, idCategory);

        return new Book(title, bookAbstract, summary, price, numberOfPages, isbn,
                publicationDate, author, category);
    }
}
