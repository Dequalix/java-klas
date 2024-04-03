package org.example.Labs.h8;

import org.example.Labs.h8.models.Person;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Reflection {
    public static void main(String[] args) {
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getMethods();
        Arrays.stream(personClass.getMethods()).forEach(x -> System.out.println(x.getName()));
    }
}
