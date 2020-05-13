package com.java.spring.security;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.java.spring.security.error.ProductNotFoundException;

@RestController
@Validated
public class ProductController {

    @Autowired
    private ProductRepository repository;

    // Find
    @GetMapping("/product")
    List<Product> findAll() {
        return repository.findAll();
    }

    // Save
    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    Product newProduct(@Valid @RequestBody Product newProduct) {
        return repository.save(newProduct);
    }

    // Find
    @GetMapping("/product/{id}")
    Product findOne(@PathVariable @Min(1) Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }


    @DeleteMapping("/product/{id}")
    void deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
    }
    @GetMapping("/config")
    List<String> getConfig() {
    	 List<Product> l =repository.findAll();
    	 List<String> s = new ArrayList<String>();
    	 for(Product lst:l)
    	 {
    		 s.add(lst.getConfig());
    	 }
    	return s;
    }

}
