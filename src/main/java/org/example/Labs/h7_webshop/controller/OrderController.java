package org.example.Labs.h7_webshop.controller;

import org.example.Labs.h7_webshop.model.Customer;
import org.example.Labs.h7_webshop.model.Order;
import org.example.Labs.h7_webshop.model.Product;
import org.example.Labs.h7_webshop.repository.CustomerRepo;
import org.example.Labs.h7_webshop.repository.OrderRepo;
import org.example.Labs.h7_webshop.repository.ProductRepo;

import java.util.List;

public class OrderController {
    OrderRepo orderRepo = new OrderRepo();
    CustomerRepo customerRepo = new CustomerRepo();
    ProductRepo productRepo = new ProductRepo();

    public Order createOrder(List<Product> items, String c) {
        Customer customer = customerRepo.findBy(c).stream().findFirst().orElse(null);
        if(customer == null) {
            return null;
        }
        return orderRepo.createOrder(items, customer);
    }

    public void addItemToOrder(Order o, int id) {
        Product product = productRepo.findById(id).stream().findFirst().orElse(null);
        if(product == null) {
            return;
        }
        orderRepo.addItemToOrder(o, product);
    }
}
