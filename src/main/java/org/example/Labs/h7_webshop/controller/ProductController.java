package org.example.Labs.h7_webshop.controller;

import jakarta.persistence.EntityManager;
import org.example.Labs.h7_webshop.model.Product;
import org.example.Labs.h7_webshop.repository.ProductRepo;

public class ProductController {
    EntityManager em;

    private final ProductRepo productRepo;

    public ProductController(EntityManager em, ProductRepo productRepo) {
        this.em = em;
        this.productRepo = productRepo;
    }


    public Product findProductBy(String name) {
        return productRepo.findByName(name).stream().findFirst().orElse(null);
    }

    public Product findProductById(int id) {
        return productRepo.findById(id);
    }

    public void createProduct(String name, String price, String description) {
        productRepo.createProduct(name, price, description);
    }
}
