package com.practice.hackerrank.domains.dataStructures.arrays;

import java.util.Scanner;

public class LeftRotation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n; i++) {
            array[i] = in.nextInt();
        }
        for(int i = d%n; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        for(int i=0; i< d%n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
