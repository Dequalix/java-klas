package org.example.Labs.h10.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.example.Labs.Overig.Exceptions.PersonDiedException;
import org.example.Labs.h7.Models.Gender;

@Data
@AllArgsConstructor
public class Person extends Human {
    private String name;
    private Gender gender;
    private int age;
    @Getter
    private static String universalRights = "All humans are created equal.";
    private static int MAX_AGE = 130;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, Gender gender) {
        this(name, age);
        this.gender = gender;
    }

    public void setAge(int age) throws PersonDiedException {
        if (age < MAX_AGE) {
            this.age = age;
            return;
        }
        throw new PersonDiedException("Person has died");
    }

    public String toString() {
        return this.name + " (" + this.age + ") is " + this.gender;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Person p) {
            return this.name.equals(p.getName()) && this.age == p.getAge() && this.getGender().equals(p.getGender());
        }
        return false;
    }

    public void haveBirthday() {
        this.setAge(this.age + 1);
    }

    @Override
    public int hashCode() {
        return this.age * name.hashCode() * gender.hashCode();
    }

    @Override
    public void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public String greet() {
        return "Hello, my name is " + this.getName() + ". Nice to meet you!.";
    }
}
