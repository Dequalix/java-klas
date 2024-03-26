package org.example.Labs.h7_webshop.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Catalog {
    private int id;
    private static int nextId;
    private final LocalDate date;
    private List<Product> items;

    public Catalog() {
        this.id = nextId;
        nextId++;
        this.date = LocalDate.now();
        items = new ArrayList<>();
    }

    public Catalog(int date, int month, int day) {
        this.date = LocalDate.of(date, month, day);
    }

    public Catalog(int date, int month, int day, List<Product> products) {
        this.date = LocalDate.of(date, month, day);
        this.items = products;
    }

}
