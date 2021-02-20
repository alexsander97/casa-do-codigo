package com.example.casadocodigo.dtos.responses;

import com.example.casadocodigo.entities.Book;

import java.math.BigDecimal;

public class BookDetailsResponse {

    private String title;

    private String bookAbstract;

    private String summary;

    private BigDecimal price;

    private Integer numberOfPages;

    private String isbn;

    private AuthorDetailsResponse author;

    public BookDetailsResponse(Book book) {
        this.title = book.getTitle();
        this.bookAbstract = book.getBookAbstract();
        this.summary = book.getSummary();
        this.price = book.getPrice();
        this.numberOfPages = book.getNumberOfPages();
        this.isbn = book.getIsbn();
        this.author = new AuthorDetailsResponse(book.getAuthor());
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

    public AuthorDetailsResponse getAuthor() {
        return author;
    }
}

