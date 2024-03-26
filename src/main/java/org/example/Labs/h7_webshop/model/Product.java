package org.example.Labs.h7_webshop.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private static int nextId = 1;
    private int id;
    private String name;
    private BigDecimal price;
    private String description;

    public Product(String name, String euroPrice, String description) {
        String numberAsString = euroPrice.replace(",", ".");
        this.name = name;
        this.id = nextId;
        this.description = description;
        nextId++;
        try {
            this.price = new BigDecimal(numberAsString);
        } catch (NumberFormatException e) {
            System.err.println("De gegeven waarde is geen geldig getal: " + numberAsString);
        }
    }
}

