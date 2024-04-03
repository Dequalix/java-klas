package org.example.Labs.h10.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AndroidTest {
    Android a;

    @BeforeEach
    void setup() {
        a = new Android(80);
    }

    @Test
    void greet() {
        System.out.println(a.greet());
    }

    @Test
    void chargeTo100() {
        a.charge(20);
        int power = a.getPower();
        System.out.println(a.greet());
    }
    @Test
    void chargeTo90() {
        a.charge(10);
        int power = a.getPower();
        System.out.println(a.greet());
    }

    @Test
    void chargeTooMuch() {
        a.charge(21);
        int power = a.getPower();
        System.out.println(a.greet());
    }
}