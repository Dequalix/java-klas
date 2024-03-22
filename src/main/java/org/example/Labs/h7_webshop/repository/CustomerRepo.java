package org.example.Labs.h7_webshop.repository;

import org.example.Labs.h7_webshop.Database;
import org.example.Labs.h7_webshop.model.Customer;

import java.util.List;

public class CustomerRepo {
    public Customer createCustomer(String name) {
        Customer c = new Customer(name);
        Database.customers.add(c);
        return c;
    }

    public Customer createCustomer(String name, String residence, String zipCode, String email ) {
        Customer c = new Customer(name, residence, zipCode, email);
        Database.customers.add(c);
        return c;
    }

    public List<Customer> findBy(String name) {
        return Database.customers.stream()
                .filter(x -> x.getName().contains(name))
                .toList();
    }

    public void save(Customer c) {
        int i = Database.customers.indexOf(c);
        Database.customers.set(i, c);
    }


}
