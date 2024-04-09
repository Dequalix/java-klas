package org.example.Labs.h14.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.Labs.Overig.Exceptions.PersonDiedException;
import org.example.Labs.h10.models.Human;
import org.example.Labs.h7.Models.Gender;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.example.Labs.h7.Models.Gender.MALE;

@Data
@AllArgsConstructor
public class Person2 extends Human implements Iterable<Person2.HistoryRecord> {
    private static String universalRights = "All humans are created equal.";
    private static int MAX_AGE = 130;
    private String name;
    private Gender gender;
    private int age;
    private List<HistoryRecord> history = new ArrayList<>();

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
        this.gender = MALE;
    }

    public Person2(String name, int age, Gender gender) {
        this(name, age);
        this.age = age;
        this.gender = gender;
    }

    public void addHistory(String s) {
        if (history == null) {
            history = new ArrayList<>();
        }
        HistoryRecord hR = new HistoryRecord(s);
        history.add(hR);
    }

    public void printHistory() {
        for (HistoryRecord hR : history) {
            System.out.println(hR.getDescription());
        }
    }

    public void createSubHuman() {
        new Person("Peter", 30) {

        };
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
        if (this == o) return true;
        if (!(o instanceof Person p)) return false;
        return this.name.equals(p.getName()) && this.age == p.getAge() && this.gender.equals(p.getGender());
    }


    public void haveBirthday() {
        this.setAge(this.age + 1);
    }

    @Override
    public int hashCode() {
        return this.age * name.hashCode() * gender.hashCode();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public String greet() {
        return "Hello, my name is " + this.getName() + ". Nice to meet you!.";
    }

    @Override
    public Iterator<HistoryRecord> iterator() {
        if (history == null) {
            history = new ArrayList<>();
        }
        return history.iterator();
    }


    @Data
    public class HistoryRecord {
        private String description;

        public HistoryRecord(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }
}
