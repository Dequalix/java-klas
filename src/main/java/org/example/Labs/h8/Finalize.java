package org.example.Labs.h8;

import org.example.Labs.h8.models.Person;

import static org.example.Labs.h7.Models.Gender.MALE;

public class Finalize {


    public static void main(String[] args) {
        Person p = new Person("Peter", 30, MALE);
        try {
            p.finalize();
        } catch (Throwable e) {
            //
        }
    }
}
