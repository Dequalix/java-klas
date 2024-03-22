package org.example.Labs.h7_webshop.controller;

import org.example.Labs.h7_webshop.model.Customer;
import org.example.Labs.h7_webshop.model.Order;
import org.example.Labs.h7_webshop.model.Product;
import org.example.Labs.h7_webshop.repository.CustomerRepo;
import org.example.Labs.h7_webshop.repository.OrderRepo;
import org.example.Labs.h7_webshop.repository.ProductRepo;

import java.util.List;

public class OrderController {
    OrderRepo orderRepo;
    CustomerRepo customerRepo;
    ProductRepo productRepo;

    public Order createOrder(List<Product> items, String c) {
        Customer customer = customerRepo.findBy(c).stream().findFirst().get();
        return orderRepo.createOrder(items, customer);
    }

    public void addItemToOrder(Order o, String p) {
        Product product = productRepo.findBy(p).stream().findFirst().get();
        orderRepo.addItemToOrder(o, product);
    }
}
