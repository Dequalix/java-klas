package org.example.Labs.h13;

import org.example.Labs.h11.models.Person;
import org.example.Labs.h13.models.House;
import org.w3c.dom.ls.LSOutput;

public class H13 {

    public static void main(String[] args) {
        House<Person> personHouse = new House<>(new Person("Peter", 30));
        System.out.println(personHouse);
    }

}
