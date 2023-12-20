package com.ahmed.springbootdatajpa.service;

import com.ahmed.springbootdatajpa.entity.Author;
import com.ahmed.springbootdatajpa.repo.AuthorRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AuthorService {

    private AuthorRepo authorRepo;


    public Author createUser(Author author) {
        return authorRepo.save(author);
    }

    public List<Author> fetchAllAuthors() {
        return authorRepo.findAll();
    }

    public Author fetchAuthorById(Long authorId) {
        return authorRepo.findById(authorId).orElseThrow();
    }

    public Author updateAuthor(Author author) {
        Author tempAuthor = authorRepo.findById(author.getId()).orElseThrow();
        tempAuthor.setName(author.getName());
        tempAuthor.setBooks(author.getBooks());
        return authorRepo.save(tempAuthor);
    }

    public void deleteAuthorById(Long authorId) {
        authorRepo.deleteById(authorId);
    }
}
