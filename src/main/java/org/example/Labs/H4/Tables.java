package org.example.Labs.H4;

import java.util.stream.IntStream;

public class Tables {
    public static int amount = Integer.MAX_VALUE - 1000000;
    public static int table = 5;

    public static void main(String[] args) {
        doTable(amount, table);
    }

    public static void doTable(int amount, int table) {
        System.out.println(IntStream.range(1, amount + 1)
                .map(i -> i * table).reduce(Integer::sum));
    }
}
