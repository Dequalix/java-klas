package org.example.Labs.h10.models;

import lombok.Data;
import org.example.Labs.h7.Models.Gender;

@Data
public abstract class Human {
    private String name;
    private Gender gender;
    private int age;

    public abstract String greet();
}
