package org.example;

import org.junit.jupiter.api.Test;

import static org.example.Calc.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {
    @Test
    void testDoubleSom() {
        // given
        double a = 5;
        double b = 14;
        // when
        double result = som(a, b);
        // then
        assertEquals(19.00, result);
    }

    @Test
    void testIntSom() {
        // given
        int a = 1;
        int b = 2;
        // when
        int result = som(a, b);
        // then
        assertEquals(3, result);
    }

    @Test
    void testDoubleMin() {
        // Given
        double a = 10;
        double b = 5;
        // When
        double result = minus(a,b);
        // Then
        assertEquals(5.00, result);
    }

    @Test
    void testIntMin() {
        // Given
        int a = 10;
        int b = 5;
        // When
        int result = minus(a,b);
        // Then
        assertEquals(5, result);
    }
}
