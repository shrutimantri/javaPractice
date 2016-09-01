package com.practice.hackerrank.domains.algorithms.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NikitaAndTheGame {
    static int[][] maximumScoreArray;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0; i<t; i++){
            int n = in.nextInt();
            int[] array = new int[n];
            for(int j=0; j<n; j++) {
                array[j] = in.nextInt();
            }
            maximumScoreArray = new int[n][n];
            for(int j=0; j<n; j++) {
                for(int k=0; k<n; k++) {
                    maximumScoreArray[j][k] = -1;
                }
            }
            System.out.println(getMaximumScore(array, 0, array.length-1));
        }
    }

    static Integer getMaximumScore(int[] array, int start, int end) {
        if(maximumScoreArray[start][end] != -1) {
            return maximumScoreArray[start][end];
        }
        List<Integer> possibleScores = new ArrayList<>();
        List<Integer> possiblePartitions = getPossiblePartitions(array, start, end);
        for(int i : possiblePartitions) {
            possibleScores.add(Math.max(getMaximumScore(array, start, i), getMaximumScore(array, i+1, end)));
        }
        int maxScore = possibleScores.size() == 0 ? 0 : getMaximum(possibleScores) + 1;
        maximumScoreArray[start][end] = maxScore;
        return maxScore;
    }

    static List<Integer> getPossiblePartitions(int[] array, int start, int end) {
        List<Integer> possiblePartitions = new ArrayList<>();
        if(start == end) {
            return possiblePartitions;
        }
        for(int i=start; i<end; i++) {
            if(arraySum(array, start, i) == arraySum(array, i+1, end)) {
                possiblePartitions.add(i);
            }
        }
        return possiblePartitions;
    }

    static long arraySum(int[] array, int start, int end) {
        long sum = 0;
        for (int i=start; i<=end; i++) {
            sum += array[i];
        }
        return sum;
    }

    static int getMaximum(List<Integer> integers) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<integers.size(); i++){
            if(integers.get(i) > max) {
                max = integers.get(i);
            }
        }
        return max;
    }
}

