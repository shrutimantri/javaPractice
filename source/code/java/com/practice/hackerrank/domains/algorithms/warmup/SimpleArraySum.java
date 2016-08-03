package com.practice.hackerrank.domains.algorithms.warmup;

import java.util.Scanner;

public class SimpleArraySum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++) {
            array[i] = in.nextInt();
            sum += array[i];
        }
        System.out.println(sum);
    }

}
