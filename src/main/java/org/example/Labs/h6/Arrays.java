package org.example.Labs.h6;

public class Arrays {

    public static long rowTwoIs() {
        long[] row = new long[4];
        row[2] = 3;
        long[] copy = row;
        copy[2]++;
        return row[2];
    }

    public static long[] fibonacci(int i) {
        long[] result = new long[(int) i];
        long l1 = 1;
        long l2 = 1;
        result[0] = l1;
        result[1] = l2;
        for (int j = 2; j < i; j++) {
            long sum = l1 + l2;
            result[j] = sum;
            l1 = l2;
            l2 = sum;
        }
        return result;
    }
}
