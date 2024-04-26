package org.example.Labs.h7_webshop.model.datatypes;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
public class ZipCode {
    @Getter
    private String code;

    public ZipCode(String code) throws IllegalArgumentException {
        setCode(code);
    }

    public ZipCode() {

    }

    public void setCode(String code) throws IllegalArgumentException {
        if (!IsValidZipCode(code)) {
            throw new IllegalArgumentException("Ongeldige postcode: " + code);
        }
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

    private boolean IsValidZipCode(String code) {
        // Nederlandse zipcode
        return code.matches("\\d{4}[A-Z]{2}");
    }
}
