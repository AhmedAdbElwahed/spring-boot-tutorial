package com.ahmed.springbootdatajpa.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "authors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
//    For databases that support auto increment like (MYSQL, Microsoft SQL Server)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    For databases that support sequence like (oracle database)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_generator")
//    @SequenceGenerator(
//            name = "author_generator",
//            sequenceName = "author_seq",
//            initialValue = 100
//    )
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author")
    private Set<Book> books;
}
