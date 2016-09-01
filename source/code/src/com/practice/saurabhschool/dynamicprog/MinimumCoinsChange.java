package com.practice.saurabhschool.dynamicprog;

import java.util.Arrays;

public class MinimumCoinsChange {
    public static void main(String[] args) {
        int[] coins = {2,3};
        System.out.print(minCoins(coins, 7));
    }

    private static  int minCoins(int[] coins, int price) {
        if (price == 0) {
            return 0;
        }
        int[] minimum = new int[coins.length];
        for(int i=0; i<coins.length; i++) {
            if(coins[i] <= price) {
                minimum[i] = minCoins(coins, price-coins[i]);
            }
            //implicit
            /*else {
                minimum[i] = 0;
            }*/
        }
        return getMinimum(minimum) + 1;
    }

    private static int getMinimum(int[] array) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<array.length; i++){
            if(array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
}
