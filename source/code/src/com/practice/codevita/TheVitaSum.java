package com.practice.codevita;


import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TheVitaSum {
    static Map<String, BigInteger> permutationMap = new HashMap<>();
    static Map<BigInteger, BigInteger> tempMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = in.nextBigInteger();
        BigInteger k = in.nextBigInteger();
        BigInteger total = BigInteger.ZERO;
        for(BigInteger i=BigInteger.ZERO; i.compareTo(k) <= 0; i = i.add(new BigInteger("2"))) {
            total = total.add(combination(n, i));
        }
        System.out.print(total.mod(new BigInteger("1000000007")).toString());
    }

    public static BigInteger combination(BigInteger n, BigInteger k)
    {
        if(permutationMap.containsKey(n+","+k)) {
            return permutationMap.get(n+","+k);
        }
        if(permutationMap.containsKey(n+","+(n.subtract(k)))) {
            return permutationMap.get(n+","+(n.subtract(k)));
        }
        BigInteger answer =  permutation(n).divide(permutation(k).multiply(permutation(n.subtract(k))));
        permutationMap.put(n+","+k, answer);
        return answer;
    }

    public static BigInteger permutation(BigInteger i)
    {
        if (i.compareTo(BigInteger.ONE) == 0 || i.compareTo(BigInteger.ONE) == -1)
        {
            return BigInteger.ONE;
        }
        if(tempMap.containsKey(i)){
            return tempMap.get(i);
        }
        BigInteger answer = i.multiply(permutation(i.subtract(BigInteger.ONE)));
        tempMap.put(i, answer);
        return answer;
    }
}
