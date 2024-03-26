package org.example.Labs.H7.Models;

import org.example.Labs.H6.Exceptions.PersonDiedException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    @Test
    void testPerson() {
        Person p = new Person("Jan", 45);
        System.out.println(p.getGender());
        p.setGender(Gender.MALE);
        System.out.println(p.getGender());
        p.haveBirthday(); // person gets one year older
        System.out.println(p.getAge());
        System.out.println(Person.getUniversalRights());
    }

    @Test
    void testPerson1() {
        Person p = new Person("Erik", 65);
        p.setGender(Gender.MALE);
        assertEquals(Gender.MALE, p.getGender());
        int expectedAge = p.getAge()+1;
        p.haveBirthday();
        assertEquals(expectedAge, p.getAge());
        assertEquals("All humans are created equal.", Person.getUniversalRights());
    }

    @Test
    void ageBelow130(){
        Person p = new Person("Erik", 130);
        Exception e = assertThrows(PersonDiedException.class, () -> p.haveBirthday());
        assertEquals("Person has died", e.getMessage());
        assertEquals(130, p.getAge());
    }
}
