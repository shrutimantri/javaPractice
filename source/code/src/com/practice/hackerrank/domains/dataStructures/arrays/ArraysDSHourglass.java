package com.practice.hackerrank.domains.dataStructures.arrays;

import java.util.Scanner;

public class ArraysDSHourglass {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] array = new int[6][6];
        for(int i=0; i<6; i++) {
            for(int j=0; j<6; j++) {
                array[i][j] = in.nextInt();
            }
        }
        int maxSum = -9*7;
        int sum;
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                sum = array[i][j] + array[i][j+1] + array[i][j+2]
                        + array[i+1][j+1]
                        + array[i+2][j] + array[i+2][j+1] + array[i+2][j+2];
                if(sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        System.out.print(maxSum);
    }
}
