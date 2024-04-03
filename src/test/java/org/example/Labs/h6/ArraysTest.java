package org.example.Labs.h6;

import org.junit.jupiter.api.Test;

import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArraysTest {

    @Test
    void rowTwoIsFour() {
        Long l = Arrays.rowTwoIs();
        assertEquals(4, l);
    }

    @Test
    void fibonacci() {
        long[] l = Arrays.fibonacci(20);
        stream(l).forEach(System.out::println);
    }
}