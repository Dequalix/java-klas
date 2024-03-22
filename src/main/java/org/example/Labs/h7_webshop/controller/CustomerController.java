package org.example.Labs.h7_webshop.controller;

import org.example.Labs.h7_webshop.model.Customer;
import org.example.Labs.h7_webshop.repository.CustomerRepo;

public class CustomerController {
    CustomerRepo customerRepo;
    public void createCustomer(String name, String residence, String zipCode, String email) {
        customerRepo.createCustomer(name, residence, zipCode, email);
    }

    public Customer findCustomer(String name) {
        return customerRepo.findBy(name).stream().findFirst().get();
    }

    public void changeName(String oldName, String newName) {
        Customer c = customerRepo.findBy(oldName).stream().findFirst().get();
        c.setName(newName);
        customerRepo.save(c);
    }

}
