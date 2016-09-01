package com.practice.hackerrank.domains.algorithms.dynamicProgramming;

import java.util.Scanner;

public class TheMaximumSubarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0; i<t; i++) {
            int n = in.nextInt();
            int[] array = new int[n];
            for(int j=0; j<n; j++) {
                array[j] = in.nextInt();
            }
            System.out.println(getContiguousSum(array) + " " + getNonContiguousSum(array));
        }
    }

    static int getContiguousSum(int[] array) {
        int[] S = new int[array.length];
        S[0] = array[0];
        for(int i=1; i<array.length; i++) {
            S[i] = Math.max(S[i-1]+array[i], array[i]);
        }
        return getMaximum(S);
    }

    static int getNonContiguousSum(int[] array) {
        int[] S = new int[array.length];
        S[0] = array[0];
        for(int i=1; i<array.length; i++) {
            int[] temp = new int[3];
            temp[0] = S[i-1];
            temp[1] = S[i-1] + array[i];
            temp[2] = array[i];
            S[i] = getMaximum(temp);
        }
        return S[array.length - 1];
    }

    static int getMaximum(int[] array) {
        int maximum = array[0];
        for(int i=1; i<array.length; i++) {
            if(maximum < array[i]) {
                maximum = array[i];
            }
        }
        return maximum;
    }
}
