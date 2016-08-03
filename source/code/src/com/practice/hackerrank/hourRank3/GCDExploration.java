package com.practice.hackerrank.hourRank3;

import com.practice.utilities.GCD;

import java.util.Scanner;

public class GCDExploration {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long a = in.nextLong();
        long b = in.nextLong();
        String n1 = String.valueOf(n);
        String nString = String.valueOf(n);
        long multiplier = 1;
        long c = GCD.gcd(a,b);
        for (int i=0; i<c-1; i++){
            n1 = n1 + nString;
        }
        System.out.println(n1);
    }
}
