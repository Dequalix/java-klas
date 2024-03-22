package org.example.Labs.H1_H6;

public class IntOverflow {
    static int a = Integer.MAX_VALUE;

    public static void main(String[] args) {
        long l = 0;
        if (a == Integer.MAX_VALUE) {
            l = (long) a + 1;
            l++;
        }
        System.out.println(Integer.MAX_VALUE);
        System.out.println(l);
    }
}


