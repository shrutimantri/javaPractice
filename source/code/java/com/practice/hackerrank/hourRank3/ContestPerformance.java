package com.practice.hackerrank.hourRank3;


import java.util.Scanner;

public class ContestPerformance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int array[] = new int[5];
        int score = 0;
        for(int i=0; i<5; i++){
            array[i] = in.nextInt();
            int penalty = (array[i] - (i+1)) * -10;
            penalty = penalty > -100 ? penalty : -100;
            score += 100 + penalty;
        }
        System.out.print(score);
    }
}
