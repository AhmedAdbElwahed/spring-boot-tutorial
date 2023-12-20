package com.ahmed.springbootdatajpa.repo;

import com.ahmed.springbootdatajpa.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
    Optional<Author> findAuthorByName(String authorName);
}
