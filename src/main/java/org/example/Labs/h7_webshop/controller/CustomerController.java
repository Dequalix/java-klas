package org.example.Labs.h7_webshop.controller;

import org.example.Labs.h7_webshop.model.Customer;
import org.example.Labs.h7_webshop.model.Order;
import org.example.Labs.h7_webshop.repository.CustomerRepo;

import java.util.List;

import static org.example.Labs.h7_webshop.Webshop.loggedInAs;

public class CustomerController {
    CustomerRepo customerRepo = new CustomerRepo();

    public void createCustomer(String name, String residence, String address, String zipCode, String email) {
        customerRepo.createCustomer(name, residence, address, zipCode, email);
    }

    public Customer findCustomer(String name) {
        return customerRepo.findBy(name).stream().findFirst().orElse(null);
    }

    public void changeName(String oldName, String newName) {
        Customer c = customerRepo.findBy(oldName).stream().findFirst().get();
        c.setName(newName);
        customerRepo.save(c);
    }

    public List<Order> orderList() {
        return loggedInAs.getOrders();
    }


}
