package com.java.spring.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;

@SpringBootApplication
public class StartBookApplication {

    // start everything
    public static void main(String[] args) {
        SpringApplication.run(StartBookApplication.class, args);
    }

    @Profile("demo")
    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            repository.save(new Product("HP Notebook","intel core i5", new BigDecimal("150.41")));
            repository.save(new Product("Dell Laptop","intel core i3",  new BigDecimal("9.69")));
            repository.save(new Product("MacBook","intel core i7", new BigDecimal("47.99")));
        };
    }
}