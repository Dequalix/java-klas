package org.example.Labs.unittest.fibo;

import java.util.ArrayList;
import java.util.List;

public class Fibo {
    private Fibo() {
    }

    public static long fibo(int i) {
        if (i <= 2) return 1;
        List<Long> result = new ArrayList<>();
        long l1 = 1;
        long l2 = 1;

        result.add(l1);
        result.add(l2);
        for (int j = 2; j < i; j++) {
            long sum = l1 + l2;
            result.add(sum);
            l1 = l2;
            l2 = sum;
        }
        return result.get(result.size() - 1);
    }
}
