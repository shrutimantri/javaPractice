package com.practice.codevita;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class CollectingCandies {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0; i<t; i++){
            int n = in.nextInt();
            Queue<Integer> queue = new PriorityQueue<Integer>();
            for(int j=0; j<n; j++) {
                queue.add(in.nextInt());
            }
            double totalSeconds = 0;
            while(!queue.isEmpty()) {
                int temp = queue.poll();
                if(queue.isEmpty()) {
                    totalSeconds += temp;
                    break;
                }
                int sum = temp + queue.poll();
                totalSeconds += sum;
                if(!queue.isEmpty()) {
                    queue.add(sum);
                }
            }
            System.out.println(String.format("%.0f",totalSeconds));
        }
    }
}
