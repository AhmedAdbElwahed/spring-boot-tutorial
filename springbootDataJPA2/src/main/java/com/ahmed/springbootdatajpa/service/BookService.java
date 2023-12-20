package com.ahmed.springbootdatajpa.service;


import com.ahmed.springbootdatajpa.entity.Author;
import com.ahmed.springbootdatajpa.entity.Book;
import com.ahmed.springbootdatajpa.repo.AuthorRepo;
import com.ahmed.springbootdatajpa.repo.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepo bookRepo;


    public Book createBook(Book author) {
        return bookRepo.save(author);
    }

    public List<Book> fetchAllBook() {
        return bookRepo.findAll();
    }

    public Book fetchBookById(Long authorId) {
        return bookRepo.findById(authorId).orElseThrow();
    }

    public Book updateBook(Book book) {
        Book tempBook = bookRepo.findById(book.getId()).orElseThrow();
        tempBook.setName(book.getName());
        tempBook.setPrice(book.getPrice());
        tempBook.setAuthor(book.getAuthor());
        return bookRepo.save(tempBook);
    }

    public void deleteBookById(Long authorId) {
        bookRepo.deleteById(authorId);
    }
}
