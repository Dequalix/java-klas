package org.example.Labs.h7_webshop.model.datatypes;

import lombok.Data;

@Data
public class Address {
    private String residence;
    private ZipCode zipCode;

    public Address(String recidence, String zipCode) {
        this.residence = recidence;
        try {
            this.zipCode = new ZipCode(zipCode);
        } catch (IllegalArgumentException e) {
            System.err.println("Fout bij het maken van het Address object: " + e.getMessage());
        }
    }

}
