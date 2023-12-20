package com.ahmed.springbootdatajpa.controller;


import com.ahmed.springbootdatajpa.entity.Author;
import com.ahmed.springbootdatajpa.service.AuthorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api/v1/author")
public class AuthorController {

    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authorService.createUser(author));
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.status(HttpStatus.OK).body(authorService.fetchAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(authorService.fetchAuthorById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthorById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body("The Author has been Deleted Successfully");
    }
}
