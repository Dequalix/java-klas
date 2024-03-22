package org.example.Labs.h7_webshop.repository;

import org.example.Labs.h7_webshop.Database;
import org.example.Labs.h7_webshop.model.Product;

import java.util.List;

public class ProductRepo {
    public void createProduct(String productName, String euroPrice) {
        Product p = new Product(productName, euroPrice);
        Database.products.add(p);
    }

    public List<Product> allProducts() {
        return Database.products;
    }

    public List<Product> findByName(String name) {
        return Database.products.stream()
                .filter(x -> x.getName().contains(name))
                .toList();
    }

    public List<Product> findById(int id) {
        return Database.products.stream().filter(x -> x.getId() == id).toList();
    }

    public void removeProduct(Product p) {
        Database.products.remove(p);
    }

}
