package org.example.Labs.h7_webshop.model.datatypes;

import lombok.Getter;

public class Email {
    @Getter
    private String email;
    private static final String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                                             "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public Email(String email) {
        setEmail(email);
    }

    public void setEmail(String email) throws IllegalArgumentException {
        if(!isValidEmail(email)) {
            throw new IllegalArgumentException("Ongeldig e-mailadress: " +email);
        }
        this.email = email;
    }

    private boolean isValidEmail(String email) {
        return email.matches(emailRegex);
    }
}