/*
This class represents a user in our system. Spring will autmatically create a database table for it. Each row is one user.
Lombok reduces boilerplate. JPA manages DB mapping
 */

// JPA is the Standard (Rule Book)
// Hibernate writes the SQL queries based on JPA.
// Our annotations '@' are instructions for Hibernate to read

package com.arjun.order_management.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity                            // JPA -> This class belongs to the database -> Spring Boot + Hibernate will scan it, create table, track changes and map objects to DB rows
@Getter                            // Lombok  -> Generates all the getter methods - getId(), getUsername(), etc
@Setter                            // Lombok -> Generates all the setter methods  - setId(), setUsername(), etc
@NoArgsConstructor                 // Lombok -> Creates default constructor - public User() {}  -> Needed by Hibernate
@AllArgsConstructor                // Lombok -> Creates a constructor with all fields
@Builder
@Table(name = "users")             // JPA -> Specifies table name in DB. If we didn't write this Hibernate will name this 'User'. We prefer plural

public class User {

    @Id                             // JPA -> Primary Key -> Same as PRIMARY KEY in SQL
    @GeneratedValue(strategy = GenerationType.IDENTITY)         // JPA -> DB will auto-generate DI (auto increment) -> In SQL AUTO_INCREMENT -> So that we don't manually set the ID
    private Long id;

    @Column(unique = true, nullable = false)            // JPA  -> This applies DB constraints -> username VARCHAR(255) UNIQUE NOT NULL
    private String username;

    private String password;

    // USER OR ADMIN
    private String role;

    //for future logic
    private boolean blocked = false;
}
