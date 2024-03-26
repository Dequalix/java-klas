package org.example.Labs.h7_webshop.model;

import lombok.Data;
import org.example.Labs.h7_webshop.model.datatypes.Address;
import org.example.Labs.h7_webshop.model.datatypes.Email;

import java.util.ArrayList;
import java.util.List;

@Data
public class Customer {
    private int id;
    private static int nextId;
    private String name;
    private Address address;
    private Email email;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.id = nextId;
        this.orders = new ArrayList<>();
        nextId++;
    }

    public Customer(String name, String residence, String address, String zipCode, String email) {
        this.name = name;
        this.address = new Address(residence, address, zipCode);
        this.email = new Email(email);
        this.id = nextId;
        this.orders = new ArrayList<>();
        nextId++;
    }

    public void addOrderToList(Order o) {
        this.orders.add(o);
    }
}
