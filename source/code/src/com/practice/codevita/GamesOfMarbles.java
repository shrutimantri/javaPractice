package com.practice.codevita;

import java.util.Scanner;

public class GamesOfMarbles {
    private static final String DARRELL = "Darrell";
    private static final String SALLY = "Sally";
    private static final String PASS = "PASS";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String NString = in.nextLine();
        int N = Integer.parseInt(NString);
        boolean invalidQuestion = false;
        String firstQuestion = null;
        int sallyPoints = 0;
        int darrellPoints = 0;
        for(int i=0; i<N; i+=2) {
            String q = in.nextLine();
            String[] question = q.split(" ");
            if(question.length != 2) {
                invalidQuestion = true;
                break;
            }
            if(i==0) {
                firstQuestion = question[0];
            }
            String[] numbers = question[1].split(",");
            int[] options = new int[numbers.length];
            if(numbers.length<2 || numbers.length>7) {
                invalidQuestion = true;
                break;
            }
            try {
                for(int j=0; j<numbers.length; j++){
                    options[j] = Integer.parseInt(numbers[j]);
                }
            } catch(NumberFormatException ex) {
                invalidQuestion = true;
                break;
            }
            if(!(DARRELL.equals(question[0]) || SALLY.equals(question[0]))) {
                invalidQuestion = true;
                break;
            }
            System.out.println(question[0] + "'s question is: " + question[1]);
            int answer = lcm(options);
            String a = in.nextLine();
            String[] answerString = a.split(" ");
            if(answerString[2].equals(PASS)) {
                System.out.println("Question is PASSed");
                System.out.println("Answer is: " + answer);
                System.out.println(answerString[1] + ": 0points");
            }
            else {
                if(answer == Integer.parseInt(answerString[2])) {
                    System.out.println("Correct Answer");
                    System.out.println(answerString[1] + ": 10points");
                    if(DARRELL.equals(answerString[1])) {
                        darrellPoints += 10;
                    } else {
                        sallyPoints += 10;
                    }
                } else {
                    System.out.println("Wrong Answer");
                    System.out.println(answerString[1] + ": 0points");
                }
            }
        }
        if(invalidQuestion) {
            System.out.println("Invalid Input");
        }
        else {
            System.out.println("Total Points:");
            if(DARRELL.equals(firstQuestion)) {
                System.out.println("Darrell: " + darrellPoints+ "points");
                System.out.println("Sally: " + sallyPoints+ "points");
            } else {
                System.out.println("Sally: " + sallyPoints+ "points");
                System.out.println("Darrell: " + darrellPoints+ "points");
            }
            if(darrellPoints == sallyPoints) {
                System.out.println("Game Result: Draw");
            } else if(darrellPoints > sallyPoints) {
                System.out.println("Game Result: Darrell is winner");
            } else {
                System.out.println("Game Result: Sally is winner");
            }
        }
    }

    private static int gcd(int a, int b)
    {
        while (b > 0)
        {
            int temp = b;
            b = a % b; // % is remainder
            a = temp;
        }
        return a;
    }

    private static int gcd(int[] input)
    {
        int result = input[0];
        for(int i = 1; i < input.length; i++) result = gcd(result, input[i]);
        return result;
    }

    private static int lcm(int a, int b)
    {
        return a * (b / gcd(a, b));
    }

    private static int lcm(int[] input)
    {
        int result = input[0];
        for(int i = 1; i < input.length; i++) result = lcm(result, input[i]);
        return result;
    }
}
