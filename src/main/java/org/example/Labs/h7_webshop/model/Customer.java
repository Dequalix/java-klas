package org.example.Labs.h7_webshop.model;

import lombok.Data;
import org.example.Labs.h7_webshop.model.datatypes.Address;
import org.example.Labs.h7_webshop.model.datatypes.Email;

import java.util.List;

@Data
public class Customer {
    private String name;
    private Address address;
    private Email email;
    private List<Order> orders;
    public Customer(String name) {
        this.name = name;
    }
    public Customer(String name, String residence,String zipCode, String email) {
        this.name = name;
        this.address = new Address(residence, zipCode);
        this.email = new Email(email);
    }

    public void addOrderToList(Order o) {
        this.orders.add(o);
    }
}
