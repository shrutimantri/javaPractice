package com.practice.codevita;

import java.util.Scanner;

public class MinProductArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arrayA = new int[n];
        int[] arrayB = new int[n];
        for(int i=0; i<n; i++){
            arrayA[i] = in.nextInt();
        }
        for(int i=0; i<n; i++){
            arrayB[i] = in.nextInt();
        }
        int[] possibleProductsArray = new int[n];
        int[] actualProductsArray = new int[n];
        int[] diffArray = new int[n];
        int diff = 2*k;
        int maxDiffIndex = -1;
        int maxDiff = -1;
        for(int i=0; i<n; i++){
            possibleProductsArray[i] = Math.min( (arrayA[i]+diff) * arrayB[i], (arrayA[i]-diff) * arrayB[i]);
            actualProductsArray[i] = arrayA[i] * arrayB[i];
            diffArray[i] = Math.abs(possibleProductsArray[i] - actualProductsArray[i]);
            if (diffArray[i] > maxDiff) {
                maxDiff = diffArray[i];
                maxDiffIndex = i;
            }
        }
        int sum = 0;
        for (int i=0; i<n; i++) {
            sum += maxDiffIndex==i ? possibleProductsArray[i] : actualProductsArray[i];
        }
        System.out.print(sum);
    }
}
