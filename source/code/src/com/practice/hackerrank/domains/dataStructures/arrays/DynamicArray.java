package com.practice.hackerrank.domains.dataStructures.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int lastAns = 0;
        List<List<Integer>> seqList = new ArrayList<>(n);
        for(int i=0; i<n ; i++) {
            seqList.add(new ArrayList<>());
        }

        for(int i=0; i<q; i++) {
            int type = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            int seq = (x ^ lastAns) % n;
            if(type == 1) {
                seqList.get(seq).add(y);
            }
            else {
                lastAns = seqList.get(seq).get(y % seqList.get(seq).size());
                System.out.println(lastAns);
            }
        }
    }
}
