package org.example.Labs.h10;

import org.example.Labs.h10.models.Teacher;

import static org.example.Labs.h7.Models.Gender.MALE;

public class H10 {
    public static void main(String[] args) {
        Teacher t = new Teacher("Peter", MALE, 30);
        System.out.println(t.greet());
    }
}
