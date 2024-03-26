package org.example.Labs.H4;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class ElevenProof {
    static String bankNumber = "73.61.60.221";

    public static void main(String[] args) {
        System.out.println(elevenProof(removePeriod(bankNumber)));
    }

    public static String removePeriod(String s) {
        s = s.replace(".", "");
        return s;
    }

    public static boolean elevenProof(String bankNumber) {
        AtomicInteger multiply = new AtomicInteger(9);
        int total = 0;
        if (bankNumber.length() > 9) {
            throw new IllegalArgumentException();
        }
        return Arrays.stream(bankNumber.split(""))
                .mapToInt(Integer::parseInt)
                .map(x -> x * multiply.getAndDecrement()).sum() % 11 == 0;
    }
}
