package org.example.Labs.h7_webshop.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Catalog {
    private final LocalDate year;
    private List<Product> items;

    public Catalog() {
        this.year = LocalDate.now();
    }

    public Catalog(int year, int month, int day) {
        this.year = LocalDate.of(year, month, day);
    }

    public Catalog(int year, int month, int day, List<Product> products) {
        this.year = LocalDate.of(year, month, day);
        this.items = new ArrayList<>();
    }


}
