package org.example.Labs.h7_webshop.model;

import jakarta.persistence.*;
import lombok.Data;
import org.example.Labs.h7_webshop.model.datatypes.Address;
import org.example.Labs.h7_webshop.model.datatypes.Email;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Embedded
    private Address address;
    @Embedded
    private Email email;
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public Customer(String name, String residence, String address, String zipCode, String email) {
        this.name = name;
        this.address = new Address(residence, address, zipCode);
        this.email = new Email(email);
        this.orders = new ArrayList<>();
    }

    public Customer() {
    }

    public String getCity() {
        return this.address.getPlaceOfResidence();
    }

    public String getStreet() {
        return address.getAddress();
    }

    public String getPostalCode() {
        return address.getZipCode().toString();
    }

    public String getEmail() {
        return email.getEmail();
    }

    public void addOrderToList(Order o) {
        this.orders.add(o);
    }


}
