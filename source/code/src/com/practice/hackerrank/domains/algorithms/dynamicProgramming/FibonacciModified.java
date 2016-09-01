package com.practice.hackerrank.domains.algorithms.dynamicProgramming;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger[] array = new BigInteger[20];
        array[0] = in.nextBigInteger();
        array[1] = in.nextBigInteger();
        int n = in.nextInt();
        for(int i=2; i<n; i++){
            array[i] = array[i-2].add(array[i-1].multiply(array[i-1]));
        }
        System.out.print(array[n-1]);
    }
}
