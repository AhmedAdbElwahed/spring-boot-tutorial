# Spring Boot Data JPA Learning Project

This repository serves as a learning project for exploring Spring Boot Data JPA, Jakarta Persistence API (formerly Java Persistence API or JPA), and related concepts. The project covers the usage of essential annotations such as `@Table`, `@Column`, `@Transactional`, and more. Additionally, it includes practical examples of working with Spring Data JPA relationships, such as `@OneToOne`, `@OneToMany`, and `@ManyToMany`.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Key Concepts Covered](#key-concepts-covered)
- [Examples](#examples)
  - [Entity Definition](#entity-definition)
  - [One-to-One Relationship](#one-to-one-relationship)
  - [One-to-Many Relationship](#one-to-many-relationship)
  - [Many-to-Many Relationship](#many-to-many-relationship)

## Prerequisites

Before getting started, ensure that you have the following prerequisites installed:

- Java (version 21)
- Spring Boot (version 3)
- MySql Database (version 8.3)

## Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/spring-boot-data-jpa-learning.git
    ```

2. Navigate to the project directory:

    ```bash
    cd spring-boot-data-jpa-learning
    ```

3. Build and run the application:

    ```bash
    ./mvnw spring-boot:run
    ```

## Key Concepts Covered

- Jakarta Persistence API (JPA)
- Spring Data JPA
- Essential annotations:
  - `@Entity`
  - `@Table`
  - `@Column`
  - `@Transactional`
  - And more...

## Examples

### Entity Definition

```java
@Entity
@Table(name = "example_entity")
public class ExampleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entity_name")
    private String entityName;

    // Other fields, getters, and setters...
}
```

### one-to-one-relationship

Let’s define two entity classes, Library and Address, having a one-to-one relationship by using the @OneToOne annotation. The association is owned by the Library end of the association:

```java
@Entity
public class Library {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    
    // standard constructor, getters, setters
}

@Entity
public class Address {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String location;

    @OneToOne(mappedBy = "address")
    private Library library;

    // standard constructor, getters, setters
}

```

### one-to-Many-relationship

```java
@Entity
public class Book {

    @Id
    @GeneratedValue
    private long id;
    
    @Column(nullable=false)
    private String title;
    
    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;
    
    // standard constructor, getter, setter
}

public class Author {
 
    //...
 
    @OneToMany(mappedBy = "author")
    private List<Book> books;
 
    //...
 
}

```

### many-to-many-relationship

To create an example of a many-to-many relationship, we’ll add a new model class, Author, which has a many-to-many relationship with the Book entity:

```java
@Entity
public class Author {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_author", 
      joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), 
      inverseJoinColumns = @JoinColumn(name = "author_id", 
      referencedColumnName = "id"))
    private List<Book> books;

    //standard constructors, getters, setters
}
```

Then we’ll add the association in the Book class as well:

```java

public class Book {
 
    //...
 
    @ManyToMany(mappedBy = "books")
    private List<Author> authors;
 
    //...
}
```
