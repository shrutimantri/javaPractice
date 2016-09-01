package com.practice.uber;

import java.util.Scanner;

/**
 * Created by shruti.mantri on 01/09/16.
 */
public class CustomStack {
    /* Sample input
    12
    push 4
    pop
    push 3
    push 5
    push 2
    inc 3 1
    pop
    push 4
    inc 2 2
    pop
    pop
     */
    static int[] stack = new int[200000];
    static int index = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for(int i=0; i<n; i++) {
            String s = in.nextLine();
            if(s.startsWith("push")) {
                stack[index] = (Integer.parseInt(s.split(" ")[1]));
                index++;
                System.out.println(stack[index-1]);
            }
            if(s.startsWith("pop")) {
                index--;
                if(index == 0) {
                    System.out.println("EMPTY");
                } else {
                    System.out.println(stack[index-1]);
                }
            }
            if(s.startsWith("inc")) {
                int x = Integer.parseInt(s.split(" ")[1]);
                int d = Integer.parseInt(s.split(" ")[2]);
                for(int j=0; j<x; j++){
                    stack[j] = stack[j]+d;
                }

                System.out.println(stack[index-1]);
            }
        }
    }
}
