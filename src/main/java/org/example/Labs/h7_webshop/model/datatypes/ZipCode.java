package org.example.Labs.h7_webshop.model.datatypes;

import lombok.Getter;

public class ZipCode {
    @Getter
    private String code;

    public ZipCode(String code) throws IllegalArgumentException {
        setCode(code);
    }

    public void setCode(String code) throws IllegalArgumentException {
        if (!IsValidZipCode(code)) {
            throw new IllegalArgumentException("Ongeldige postcode: " + code);
        }
        this.code = code;
    }

    private boolean IsValidZipCode(String code) {
        // Nederlandse zipcode
        return code.matches("\\d{4}[A-Z]{2}");
    }
}
