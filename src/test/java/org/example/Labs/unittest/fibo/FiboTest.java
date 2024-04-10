package org.example.Labs.unittest.fibo;

import org.junit.jupiter.api.Test;

import static org.example.Labs.unittest.fibo.Fibo.fibo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiboTest {
    @Test
    public void fibo1Is1() {
        assertEquals(1, fibo(1));
    }

    @Test
    public void fibo2Is1() {
        assertEquals(1, fibo(2));
    }

    @Test
    public void fibo3Is2() {
        assertEquals(2, fibo(3));
    }

    @Test
    public void fibo4Is3() {
        assertEquals(3, fibo(4));
    }

    @Test
    public void fibo5Is5() {
        assertEquals(5, fibo(5));
    }

    @Test
    public void fibo120Is4376692037216111008() {
        assertEquals(4376692037216111008L, fibo(120));
    }

}
