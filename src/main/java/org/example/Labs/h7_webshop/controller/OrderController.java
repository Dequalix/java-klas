package org.example.Labs.h7_webshop.controller;

import jakarta.persistence.EntityManager;
import org.example.Labs.h7_webshop.model.Customer;
import org.example.Labs.h7_webshop.model.Order;
import org.example.Labs.h7_webshop.model.Product;
import org.example.Labs.h7_webshop.repository.CustomerRepo;
import org.example.Labs.h7_webshop.repository.OrderRepo;
import org.example.Labs.h7_webshop.repository.ProductRepo;

import java.util.List;

public class OrderController {
    EntityManager em;
    OrderRepo orderRepo;
    CustomerRepo customerRepo;
    ProductRepo productRepo;

    public OrderController(EntityManager em, OrderRepo orderRepo, CustomerRepo customerRepo, ProductRepo productRepo) {
        this.em = em;
        this.customerRepo = customerRepo;
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }


    public Order createOrder(List<Product> items, String c) {
        Customer customer = customerRepo.findBy(c).stream().findFirst().orElse(null);
        if (customer == null) {
            return null;
        }
        return orderRepo.createOrder(items, customer);
    }

    public Order createOrder(List<Product> items, Customer c) {
        return orderRepo.createOrder(items, c);
    }

    public void addItemToOrder(Order o, int id) {
        Product product = productRepo.findById(id);
        if (product == null) {
            return;
        }
        orderRepo.addItemToOrder(o, product);
    }
}
