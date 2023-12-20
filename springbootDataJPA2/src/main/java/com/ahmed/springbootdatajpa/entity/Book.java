package com.ahmed.springbootdatajpa.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    It creates a table for auto incrementing the primary key
//    @GeneratedValue(strategy = GenerationType.TABLE, generator = "book_gen")
//    @TableGenerator(name = "book_gen",
//            table = "book_seq",
//            initialValue = 100,
//            valueColumnName = "next_value"
//    )
    private Long id;

    private String name;

    private Double price;

    private Integer numberOfPages;

    @ManyToOne
    @JoinColumn(name = "auther_id")
    private Author author;
}
