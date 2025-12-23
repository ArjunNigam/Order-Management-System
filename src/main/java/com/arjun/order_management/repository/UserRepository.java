// This interface gives us automatic database queries for teh User table without writing SQL

/*
This is Database Access layer
We use it to:
    * save user
    * find user
    * update user
    * delete user
 */
package com.arjun.order_management.repository;

import com.arjun.order_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>{        // JpaRepository<User, Long> means Entity : User and Primary Key Type : Long
                                                                          // By extending this, Spring auto-creates SQL Logic. We instantly get methods like: save(), findAll(), findById(), deleteById()

    Optional<User> findByUsername(String username);                       // Spring sees: findBy + Username and automatically generates SQL:
                                                                          // SELECT * FROM users WHERE username = ?
                                                                          // This returns Optional<User> -> meaning if user exists -> return user inside Optional
                                                                          //                                 if user doesn't exist -> return empty Optional avoiding null pointers
}
