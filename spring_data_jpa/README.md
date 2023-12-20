# Spring Data JPA Learning Project

Welcome to the Spring Data JPA learning project! This repository is dedicated to exploring advanced features and best practices in Spring Data JPA. Throughout this project, you will gain insights into various annotations, repository interfaces, and techniques that enhance your understanding of Java Persistence API (JPA) with the Spring framework.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Key Features](#key-features)
- [Annotations Explored](#annotations-explored)
  - [@SqlResultSetMapping](#sqlresultsetmapping)
  - [@NamedNativeQuery](#namednativequery)
  - [@Query](#query)
  - [@Repository](#repository)
  - [@Param](#param)
- [Repository Interface](#repository-interface)
- [Named Queries in Spring Data JPA](#named-queries-in-spring-data-jpa)
- [Projection Interfaces](#projection-interfaces)

## Prerequisites

Before running the project, ensure that you have the following prerequisites installed:

- Java (version X.X)
- Spring Boot (version X.X)
- Other dependencies...

## Getting Started

1. Clone the repository:

    ```bash
    git clone https://github.com/your-username/spring-data-jpa-project.git
    ```

2. Navigate to the project directory:

    ```bash
    cd spring-data-jpa-project
    ```

3. Build and run the application:

    ```bash
    ./mvnw spring-boot:run
    ```

## Project Structure

    spring-data-jpa-project
    ├── src
    │ ├── main
    │ │ ├── java
    │ │ │ └── com
    │ │ │ └── example
    │ │ │ └── jpa
    │ │ │ ├── model
    │ │ │ │ └── ...
    │ │ │ ├── repository
    │ │ │ │ └── ...
    │ │ │ └── service
    │ │ │ └── ...
    │ │ └── resources
    │ │ └── ...
    └── ...

## Key Features

- Exploration of advanced Spring Data JPA features.
- Practical examples illustrating various concepts.
- Clear documentation on key annotations and techniques.

## Annotations Explored

Entity objects look like this

```java
@Entity
public class Employee {
    @Id
    private Long id;
    private String name;
}
```

Entity objects might be named differently than database tables. We can annotate the class with @Table to explicitly map them:

```java
@Entity
@Table(name = "SCHEDULE_DAYS")
public class ScheduledDay {

    @Id
    @GeneratedValue
    private Long id;
    private Long employeeId;
    private String dayOfWeek;
}
```

### @SqlResultSetMapping

While SqlResultSetMapping and Query annotations work on Repository classes as well, we use the annotations on an Entity class in this example.

Every SqlResultSetMapping annotation requires only one property, name. However, without one of the member types, nothing will be mapped. The member types are ColumnResult, ConstructorResult, and EntityResult.

In this case, ColumnResult maps any column to a scalar result type:

```java
@SqlResultSetMapping(
  name="FridayEmployeeResult",
  columns={@ColumnResult(name="employeeId")})
```

### @NamedNativeQuery

The ColumnResult property name identifies the column in our query:

```java
@NamedNativeQuery(
  name = "FridayEmployees",
  query = "SELECT employeeId FROM schedule_days WHERE dayOfWeek = 'FRIDAY'",
  resultSetMapping = "FridayEmployeeResult")
```

### @Query

In order to define SQL to execute for a Spring Data repository method, we can annotate the method with the @Query annotation — its value attribute contains the JPQL or SQL to execute.

```java
@Query("SELECT emp FROM User Employee WHERE emp.status = 1")
Collection<User> findAllEmployees();
```

### @Repository

It is used to identify that the interface is a repository and to be treated as bean inside spring context.

```java
@Repository
public interface ProductRepository extends JpaRepository<Employee, Long> {
}
```

### @Param

It is used to give a different name to the parameter in your jpql method

```java
    @Query("select emp from #{#entityName} emp where emp.name = :empName")
    List<Employee> filter(@Param("empName") String empName);
```

## Repository Interface

The project leverages the `JpaRepository<T, ID>` interface, which provides powerful CRUD functionalities out of the box.

## Named Queries in Spring Data JPA

Named queries enhance maintainability and readability of complex queries.

- [for more info about named queries](https://www.baeldung.com/hibernate-named-query)

## Projection Interfaces

Projection interfaces are employed to map query results to specific data structures.
