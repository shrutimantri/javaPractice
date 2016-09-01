package com.practice.hackerrank.domains.algorithms.dynamicProgramming;

import java.util.Scanner;

//2 test cases out of 15 are failing
public class Candies {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = in.nextInt();
        }
        System.out.println(arraySum(getCandiesArray(array)));
        /*int[] candies =getCandiesArray(array);
        for(int i =0; i<candies.length; i++) {
            System.out.println(array[i] + " " + candies[i] + " ") ;
        }*/
    }

    static int[] getCandiesArray(int[] array) {
        int[] candies = new int[array.length];
        for(int i=0; i<array.length; i++) {
            if(i==0) {
                candies[i] = 1;
                continue;
            }
            if(array[i-1] == array[i]) {
                candies[i] = 1;
                continue;
            }
            if(array[i-1] < array[i]) {
                candies[i] = candies[i-1] +1;
            }
            if(array[i-1] > array[i]) {
                if(candies[i-1] != 1) {
                    candies[i] = 1;
                }
                else {
                    candies[i] = 1;
                    int j = i;
                    while (j>0  && candies[j-1] == candies[j] && array[j-1] != array[j]) {
                        candies[j-1] = candies[j-1] + 1;
                        j--;
                    }
                }
            }
        }
        return candies;
    }

    static int arraySum(int[] array) {
        int sum =0;
        for(int i=0; i<array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}
