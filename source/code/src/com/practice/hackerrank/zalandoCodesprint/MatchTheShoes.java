package com.practice.hackerrank.zalandoCodesprint;

import java.util.*;

public class MatchTheShoes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int[] shoes = new int[m];
        for(int i=0; i<n; i++) {
            shoes[in.nextInt()]++;
        }
        Map<Integer, List<Integer>> treeMap = new TreeMap<Integer, List<Integer>>(new DescComparator());

        for(int i=0; i<m; i++) {
            if(treeMap.containsKey(shoes[i])) {
                treeMap.get(shoes[i]).add(i);
            }
            else {
                List<Integer> temp = new ArrayList();
                temp.add(i);
                treeMap.put(shoes[i], temp);
            }
        }
        int count = 0;
        for(Map.Entry<Integer, List<Integer>> e : treeMap.entrySet()) {
            if (count >= k) {
                break;
            }
            for(int i : e.getValue()) {
                System.out.println(i);
                count++;
                if (count >= k) {
                    break;
                }
            }
        }
    }

    static class DescComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer e1, Integer e2) {
            return e2.compareTo(e1);
        }
    }
}
