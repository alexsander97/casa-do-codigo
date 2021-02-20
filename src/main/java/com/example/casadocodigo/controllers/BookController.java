package com.example.casadocodigo.controllers;

import com.example.casadocodigo.dtos.requests.NewBookRequest;
import com.example.casadocodigo.dtos.responses.BookDetailsResponse;
import com.example.casadocodigo.dtos.responses.BookResponseDto;
import com.example.casadocodigo.entities.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @PersistenceContext
    public EntityManager entityManager;

    @PostMapping
    @Transactional
    public void create(@RequestBody @Valid NewBookRequest request) {
        Book book = request.toEntity(entityManager);
        entityManager.persist(book);
    }

    @GetMapping
    public List<BookResponseDto> getAllBooks() {
        List<Book> books = entityManager.createQuery("select b from Book b", Book.class).getResultList();
        return books.stream().map(book -> new BookResponseDto(book)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDetailsResponse> getBookDetailsById(@PathVariable("id") Long id) {
        Book book = entityManager.find(Book.class, id);
        if ( book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new BookDetailsResponse(book));
    }
}
