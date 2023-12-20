package com.ahmed.springbootdatajpa.repo;

import com.ahmed.springbootdatajpa.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

    List<Book> findBooksByAuthor_Name(String authorName);
    Optional<Book> findBookByName(String bookName);
}
