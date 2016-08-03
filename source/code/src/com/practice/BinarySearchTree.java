package com.practice;

import java.util.Scanner;

public class BinarySearchTree {
    // Accept two space separated numbers and output their sum
    public static void main(String[] args) {

            Scanner s = new Scanner(System.in);
            for(int i = 0; i < s.nextInt(); i++){
                int noOfCoins = s.nextInt();
                int[] coins = new int[noOfCoins];
                s.nextLine();
                String coinString = s.nextLine();
                for(int j = 0; j<noOfCoins; j++){
                    coins[j] = Integer.parseInt(coinString.split(" ")[j]);
                }
                int sum = s.nextInt();
                for(int j = 0; j<noOfCoins; j++){
                    System.out.println(coins[j]);
                }
                System.out.println("Sum : " + sum);
                s.nextLine();
            }
        }
}

