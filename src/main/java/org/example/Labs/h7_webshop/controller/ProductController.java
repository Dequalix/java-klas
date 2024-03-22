package org.example.Labs.h7_webshop.controller;

import org.example.Labs.h7_webshop.model.Product;
import org.example.Labs.h7_webshop.repository.ProductRepo;

import java.util.List;

public class ProductController {
    private ProductRepo productRepo;
    public Product findProductBy(String name) {
        return productRepo.findBy(name).stream().findFirst().get();
    }
    public void createProduct(String name, String price) {
        productRepo.createProduct(name, price);
    }
}
