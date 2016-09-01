package com.practice;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shruti.mantri on 05/04/15.
 */
public class TestCode {
    public static void main(String[] args){
        /*for(int i = 1; i<=20; i++) {
            System.out.println( i + " : " +convert(i));
        }*/
        //convert(4);
        Set s = new HashSet<>();
        s.add(new String("Shruti"));
        s.add(new String("Shruti"));
        System.out.print(s.size());
    }

    public static String convert(int n) {
        if (n == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();

        while (n > 0) {
            if ((n & 1) == 1) {
                sb.append("A");
            } else {
                sb.append("B");
                n -= 1;
            }
            n >>= 1;
        }

        return sb.reverse().toString();
    }
}
