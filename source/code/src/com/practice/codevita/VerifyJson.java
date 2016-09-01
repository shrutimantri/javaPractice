package com.practice.codevita;

import java.util.Scanner;

public class VerifyJson {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String json = in.nextLine().trim();
        for(int i=0; i<json.length(); i++){
            if(i==0 && json.charAt(0) != '{') {
                System.out.println("-1");
                return;
            }
            if(i==json.length()-1 && json.charAt(i) != '}') {
                System.out.println("-1");
                return;
            }
            if(json.charAt(i) == '['){
                int j = i+1;
                if(json.charAt(j) == ']'){
                    System.out.println("-1");
                    return;
                }
                while(json.charAt(j)!=']'){
                    if(!((json.charAt(j)=='{' && json.charAt(j+1)=='}') || (json.charAt(j)==','))){
                        System.out.println("-1");
                        return;
                    }
                    if(json.charAt(j) == '{'){
                        j+=2;
                        if((json.charAt(j)==',' && json.charAt(j+1) == ']') || (json.charAt(j) == '{')) {
                            System.out.println("-1");
                            return;
                        }
                    }
                    if(json.charAt(j)==','){
                        j++;
                    }
                }
                i=j;
            }
            if(json.charAt(i)==':') {
                if(!(json.charAt(i+1)==','||json.charAt(i+1)=='['||json.charAt(i+1)=='{'||json.charAt(i+1)=='}')){
                    System.out.println("-1");
                    return;
                }
            }
            if(json.charAt(i)==',' && !(json.charAt(i+1) == ':')){
                System.out.println("-1");
                return;
            }
            if(json.charAt(i)=='{' && i!=0 && !(json.charAt(i+1) == '}')){
                System.out.println("-1");
                return;
            }
            if(i!=json.length()-1 && json.charAt(i) == '}' && !(json.charAt(i+1)==',')) {
                System.out.println("-1");
                return;
            }
            if(i!=json.length()-1 && json.charAt(i) == ']' && !(json.charAt(i+1)==',' || json.charAt(i+1)=='}')) {
                System.out.println("-1");
                return;
            }
        }
        System.out.println("1");
    }
}
