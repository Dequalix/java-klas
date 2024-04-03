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
    void charge() {
        a.charge(20);
        System.out.println(a.greet());
    }
}