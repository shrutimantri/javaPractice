package com.practice.utilities;

/**
 * Created by shruti.mantri on 08/03/15.
 */
public class GCD {
    public static void main(String[] args){
        gcd(12, 18);
    }

    public static long gcd(long a, long b) {
        long y = 0;
        long x = 0;

        if (a > b) {
            x = a;
            y = b;
        } else {
            x = b;
            y = a;
        }

        while (x % y != 0) {
            long temp = x;
            x = y;
            y = temp % x;
        }
        return y;
    }
}
