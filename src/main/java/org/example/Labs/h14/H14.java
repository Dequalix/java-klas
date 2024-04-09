package org.example.Labs.h14;

import com.github.javafaker.Faker;
import org.example.Labs.h14.models.Person;
import org.example.Labs.h14.models.Person2;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

import static org.example.Labs.h7.Models.Gender.*;

public class H14 {
    private final Person p = new Person("Peter", 42);
    private static final H14 h14 = new H14();
    private final Faker faker = new Faker();
    private final Set<Person> personSet = new HashSet<>();


    public static void main(String[] args) {
//        h14.hashSetExample();
//        h14.treeSetExample();
//        h14.treeMapExample();
        h14.iterableExample();
    }

    public void iterableExample() {
        Person2 p = new Person2("David", 42);
        p.addHistory(p.getName() + " is geboren");
        p.addHistory(p.getName() + " ging naar school");
        p.addHistory(p.getName() + " is afgestudeerd");
        p.addHistory(p.getName() + " is dood");

        for (Person2.HistoryRecord hr : p) {
            System.out.println(hr.getDescription());
        }
    }

    public void treeSetExample() {
        TreeSet<Person> people = new TreeSet<>();
        people.add(new Person("Alice", 30, FEMALE));
        people.add(new Person("Bob", 30, MALE));
        people.add(new Person("Bob", 25, MALE));
        people.add(new Person("Charlie", 22, MALE));
        people.add(new Person("Alice", 25, FEMALE));

        for (Person p : people) {
            System.out.println(p);
        }
    }

    public void treeMapExample() {
        TreeMap<Person, String> personMap = new TreeMap<>();
        personMap.put(new Person("Alice", 30, FEMALE), "Alice's gegevens");
        personMap.put(new Person("Karel", 30, MALE), "Kareltje houd van koken");
        personMap.put(new Person("Bob", 30, MALE), "Bob doet bouwen");
        personMap.put(new Person("Bob", 25, MALE), "Bob doet bouwen");
        personMap.put(new Person("Charlie", 22, MALE), "Charlie's gegevens");
        personMap.put(new Person("Alice", 25, FEMALE), "Jonge Alice's gegevens");

        for (Map.Entry<Person, String> entry : personMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void hashSetExample() {
        h14.addPersonsToHashSet(10);
        h14.getPersonFromHashAndAddAgain();
        System.out.println("--------------------------------------------------------------------");
        for (Person person : h14.personSet) {
            System.out.println(person);
        }
    }

    public void testCollection() {
        p.addHistory("Peter");
        p.addHistory("Karel");
        p.addHistory("Maarten");
        p.printHistory();
    }

    private void addPersonsToHashSet(int amount) {
        for (int i = 0; i < amount; i++) {
            personSet.add(new Person(faker.name().firstName(), 42));
        }
    }

    private void getPersonFromHashAndAddAgain() {
        Person person = personSet.iterator().next();
        boolean wasAdded = personSet.add(new Person(person.getName(), person.getAge(), person.getGender()));
        System.out.println("Duplicated is added: " + wasAdded);
        System.out.println("HashSet size: " + personSet.size());
    }
}
