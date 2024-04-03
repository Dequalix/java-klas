package org.example.Labs.h5;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Methods {

    public static int greatest(int a, int b) {
        return Math.max(b, a);
    }

    public static String greatest(String a, String b) {
        AtomicInteger lengthA = new AtomicInteger(0);
        AtomicInteger lengthB = new AtomicInteger(0);
        Arrays.stream(a.split("")).forEach(i -> lengthA.getAndIncrement());
        Arrays.stream(b.split("")).forEach(i -> lengthB.getAndIncrement());
        if (lengthB.get() < lengthA.get()) return a;
        return b;
    }

    public static int factorial(int i) {
        if (i <= 1) {
            return 1;
        }
        return i * factorial(i - 1);
    }

}
