package org.example.Labs.h7_webshop.repository;

import org.example.Labs.h7_webshop.Database;
import org.example.Labs.h7_webshop.model.Catalog;
import org.example.Labs.h7_webshop.model.Product;

import java.util.List;

public class CatalogRepo {
    public Catalog createCatalog() {
        Catalog c = new Catalog();
        Database.catalogs.add(c);
        return c;
    }

    public List<Catalog> findAllCatalogs() {
        return Database.catalogs;
    }


    public List<Product> finCatalogByYear(int year) {
        return Database.catalogs.stream()
                .filter(x -> x.getDate().getYear() == year)
                .findFirst().orElse(new Catalog())
                .getItems();
    }
}
