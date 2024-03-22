package org.example.Labs.h7_webshop.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private String name;
    private BigDecimal price;

    public Product(String name, String euroPrice) {
        String numberAsString = euroPrice.replace(",", ".");
        this.name = name;
        try {
            this.price = new BigDecimal(numberAsString);
        } catch (NumberFormatException e) {
            System.err.println("De gegeven waarde is geen geldig getal: " + numberAsString);
        }
    }
}

