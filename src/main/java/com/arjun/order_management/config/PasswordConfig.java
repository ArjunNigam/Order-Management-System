/*
We tell Spring to use BCrypt hashing wherever we encode passwords, and we make it globally reusable using a Spring Bean
 */
/*
GOAL : We must never store plain passwords
Instead :
    -> user types password
    -> we convert to encrypted form
    -> store encrypted
    -> on login we encrypt again and compare

Spring requires a PasswordEncoder bean for this
 */

package com.arjun.order_management.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration                              // @Configuration -> This class defines some Spring-managed configuration beans. Spring scans it automatically
public class PasswordConfig {

    @Bean                                           // @Bean -> Spring, create this object and manage it in our Application Context. So now anywhere in our project we can do
                                                    // @Autowired
                                                    //Password Encoder encoder; and Spring will inject BCryptPassword Encoder
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
/*
BCrypt -> A secure hashing algorithm
    * irreversible
    * salted
    * widely used in industry
    * supported by Spring Security
    * used by companies like Google, Meta, etc

So when user registers ->
password = encoder.encode(rawPassword)

In DB it becomes something like -
$2a$10$VEykjNQ3sYJH4dHohsuLA....

 */