package org.example.Labs.H5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MethodsTest {

    @Test
    void greatestABiggerThenB() {
        int a = 10;
        int b = 8;
        int result = Methods.greatest(a, b);
        assertEquals(a, result);
    }

    @Test
    void greatestBBiggerThenA() {
        int a = 8;
        int b = 10;
        int result = Methods.greatest(a, b);
        assertEquals(b, result);
    }

    @Test
    void textAIsLongerThenB() {
        String a = "lange tekst";
        String b = "kort";
        String result = Methods.greatest(a, b);
        assertEquals(a, result);
    }

    @Test
    void textBIsLongerThenA() {
        String b = "lange tekst";
        String a = "kort";
        String result = Methods.greatest(a, b);
        assertEquals(b, result);
    }

    @Test
    void factorial() {
        int i = 5;
        System.out.println(Methods.factorial(i));
    }

}