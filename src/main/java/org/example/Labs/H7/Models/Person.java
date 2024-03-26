package org.example.Labs.H7.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.example.Labs.H6.Exceptions.PersonDiedException;

@Data
@AllArgsConstructor
public class Person {
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
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void setAge(int age) throws PersonDiedException {
        if (age < MAX_AGE) {
            this.age = age;
            return;
        }
        throw new PersonDiedException("Person has died");
    }

    public void haveBirthday() {
        this.setAge(this.age + 1);
    }

}
