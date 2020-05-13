package com.java.spring.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.java.spring.security.error.validator.Config;

import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @NotEmpty(message = "Please provide a name")
    private String name;

    @Config
    @NotEmpty(message = "Please provide a Config")
    private String Config;

    @NotNull(message = "Please provide a price")
    @DecimalMin("1.00")
    private BigDecimal price;

    // avoid this "No default constructor for entity"
    public Product() {
    }

    public Product(Long id, String name, String Config, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.Config = Config;
        this.price = price;
    }

    public Product(String name, String Config, BigDecimal price) {
        this.name = name;
        this.Config = Config;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConfig() {
        return Config;
    }

    public void setConfig(String Config) {
        this.Config = Config;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Config='" + Config + '\'' +
                ", price=" + price +
                '}';
    }
}
