package org.example.Labs;

public class IntOverflow {
    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        long l = 0;
        if (a == Integer.MAX_VALUE) {
            l = (long) a + 1;
            l++;
        }
        System.out.println(Integer.MAX_VALUE);
        System.out.println(l);
    }
}


