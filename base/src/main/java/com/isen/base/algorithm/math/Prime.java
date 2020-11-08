package com.isen.base.algorithm.math;

/**
 * @author Isen
 * @date 2020/5/25 19:46
 * @since 1.0
 */
public class Prime {

    public static boolean isPrime(int num) {
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int count(int start, int end) {
        int res = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                res++;
            }
        }

        return res;
    }
}
