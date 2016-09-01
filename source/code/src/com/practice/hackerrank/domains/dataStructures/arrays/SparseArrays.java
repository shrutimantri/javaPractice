package com.practice.hackerrank.domains.dataStructures.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//This question is done via Maps.
public class SparseArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Map<String, Integer> map = new HashMap();
        for(int i=0; i<n; i++) {
            String s = in.nextLine();
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        int q = Integer.parseInt(in.nextLine());
        for(int i=0; i<q; i++) {
            String s = in.nextLine();
            System.out.println(map.getOrDefault(s, 0));
        }
    }
}
