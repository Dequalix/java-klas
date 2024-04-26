package org.example.Labs.h7_webshop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private final LocalDate date;
    @OneToMany(mappedBy = "catalog")
    private List<Product> items;

    public Catalog() {
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
