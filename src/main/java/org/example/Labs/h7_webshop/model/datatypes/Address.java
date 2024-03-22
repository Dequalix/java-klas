package org.example.Labs.h7_webshop.model.datatypes;

import lombok.Data;

@Data
public class Address {
    private String placeOfResidence;
    private String address;
    private ZipCode zipCode;

    public Address(String recidence,String address, String zipCode) {
        this.placeOfResidence = recidence;
        this.address = address;
        try {
            this.zipCode = new ZipCode(zipCode);
        } catch (IllegalArgumentException e) {
            System.err.println("Fout bij het maken van het Address object: " + e.getMessage());
        }
    }

}
