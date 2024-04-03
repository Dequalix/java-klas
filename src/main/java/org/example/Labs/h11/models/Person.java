package org.example.Labs.h11.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.Labs.Overig.Exceptions.PersonDiedException;
import org.example.Labs.h10.models.Human;
import org.example.Labs.h7.Models.Gender;

import java.util.Arrays;

@Data
@AllArgsConstructor
public class Person extends Human {
    private String name;
    private Gender gender;
    private int age;
    private String[] history = new String[20];
    private static String universalRights = "All humans are created equal.";
    private static int MAX_AGE = 130;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private class HistoryRecord {
        private String description;

        HistoryRecord(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }

    public void addHistory(String s) {
        HistoryRecord hR = new HistoryRecord(s);
        for (int i =0; i < history.length; i++) {
            if (history[i] == null) {
                System.out.println(history[i] = hR.toString());
                return;
            }
        }
    }

    public void printHistory() {
        for (String s : history) {
            if (s == null) return;
            System.out.println(s);
        }
    }

    public void createSubHuman() {
        new Person("Peter",  30) {

        };
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
