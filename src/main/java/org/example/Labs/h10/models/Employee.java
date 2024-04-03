package org.example.Labs.h10.models;

import org.example.Labs.h7.Models.Gender;

public class Employee extends Person {
    public Employee(String name, Gender gender, int age) {
        super(name, gender, age);
    }

    public Employee(String name, int age) {
        super(name, age);
    }

    public Employee(String name, int age, Gender gender) {
        super(name, age, gender);
    }

    public String greet() {
        return "I'm tired of working. This is inhuman!";
    }
}
