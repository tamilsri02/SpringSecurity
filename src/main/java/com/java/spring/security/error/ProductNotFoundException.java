package com.java.spring.security.error;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Product id not found : " + id);
    }

}
