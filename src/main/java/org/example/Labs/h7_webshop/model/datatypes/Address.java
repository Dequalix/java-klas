package org.example.Labs.h7_webshop.model.datatypes;

import jakarta.persistence.*;
import lombok.Data;
import org.example.Labs.h7_webshop.model.Customer;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String placeOfResidence;
    private String address;
    @Embedded
    private ZipCode zipCode;
    @OneToOne(mappedBy = "address")
    private Customer customer;

    public Address(String recidence, String address, String zipCode) {
        this.placeOfResidence = recidence;
        this.address = address;
        try {
            this.zipCode = new ZipCode(zipCode);
        } catch (IllegalArgumentException e) {
            System.err.println("Fout bij het maken van het Address object: " + e.getMessage());
        }
    }

    public Address() {

    }
}
