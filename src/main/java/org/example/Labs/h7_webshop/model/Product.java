package org.example.Labs.h7_webshop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private BigDecimal price;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL)
    private Catalog catalog;

    public Product(String name, String euroPrice, String description) {
        String numberAsString = euroPrice.replace(",", ".");
        this.name = name;
        this.description = description;
        try {
            this.price = new BigDecimal(numberAsString);
        } catch (NumberFormatException e) {
            System.err.println("De gegeven waarde is geen geldig getal: " + numberAsString);
        }
    }

    public Product() {
    }
}

