package com.practice.codevita;

import java.util.Scanner;

public class LogicPyramid {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int numbers[] = new int[91];
        int diff[] = new int[91];
        numbers[0] = 6;
        diff[0] = 22;
        for(int i=1; i<=90; i++) {
            diff[i] = diff[i-1] + 16;
            numbers[i] = numbers[i-1] + diff[i-1];
        }
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=n; j>i; j--) {
                System.out.print(" ");
            }
            for(int j=0; j<=i; j++) {
                System.out.printf("%05d ", numbers[count++]);
            }
            System.out.println();
        }

    }
}
