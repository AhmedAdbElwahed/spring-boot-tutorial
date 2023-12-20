package com.ahmed.springbootdatajpa.controller;


import com.ahmed.springbootdatajpa.entity.Author;
import com.ahmed.springbootdatajpa.entity.Book;
import com.ahmed.springbootdatajpa.service.BookService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {

    private BookService bookService;


    @PostMapping
    public ResponseEntity<Book> createAuthor(@RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(book));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllAuthors() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.fetchAllBook());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.fetchBookById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body("The Book has been Deleted Successfully");
    }
}
