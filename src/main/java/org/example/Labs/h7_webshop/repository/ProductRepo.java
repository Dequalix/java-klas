package org.example.Labs.h7_webshop.repository;

import jakarta.persistence.EntityManager;
import org.example.Labs.h7_webshop.model.Product;

import java.util.List;

public class ProductRepo extends Repository {

    public ProductRepo(EntityManager em) {
        super(em);
    }

    public void createProduct(String productName, String euroPrice, String description) {
        Product p = new Product(productName, euroPrice, description);
        PerformTransActionConsumer(em::merge, p);
    }

    public List<Product> allProducts() {
        return em.createQuery("select p from Product p", Product.class)
                .getResultList();
    }

    public List<Product> findByName(String name) {
        return em.createQuery("select p from Product p where p.name = :n", Product.class)
                .setParameter("n", name)
                .getResultList();
    }

    public Product findById(int id) {
        return em.find(Product.class, id);
    }

    public void removeProduct(Product p) {
        PerformTransActionConsumer(em::remove, p);
    }

}
