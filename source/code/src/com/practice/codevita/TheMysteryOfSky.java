package com.practice.codevita;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TheMysteryOfSky {
    final static String DATE_FORMAT = "dd/MM/yyyy";
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap();
        map.put("Sunday", 0);
        map.put("Monday", 1);
        map.put("Tuesday", 2);
        map.put("Wednesday", 3);
        map.put("Thursday", 4);
        map.put("Friday", 5);
        map.put("Saturday", 6);
        Map<Integer, String> reverseMap = new HashMap();
        reverseMap.put(0,"Sunday");
        reverseMap.put(1,"Monday");
        reverseMap.put(2,"Tuesday");
        reverseMap.put(3,"Wednesday");
        reverseMap.put(4,"Thursday");
        reverseMap.put(5,"Friday");
        reverseMap.put(6,"Saturday");
        Scanner in = new Scanner(System.in);
        String day = in.nextLine();
        if(day.equals("Sunday") || day.equals("Monday") || day.equals("Tuesday") || day.equals("Wednesday")
                || day.equals("Thursday") || day.equals("Friday") || day.equals("Saturday")) {
            String date = in.nextLine();
            boolean isValidDate = checkDateValidity(date);
            if (isValidDate) {

                    int d = Integer.parseInt(date.split("/")[0]);
                    int month = Integer.parseInt(date.split("/")[1]);
                    int year = Integer.parseInt(date.split("/")[2]);
                    Calendar baseCal = Calendar.getInstance();
                    baseCal.set(1, 0, 1);
                    Calendar cal = Calendar.getInstance();
                    cal.set(year, month - 1, d);
                    int totalDays = daysBetween(baseCal.getTime(), cal.getTime());
                    String thatDay = reverseMap.get((map.get(day)+totalDays)% 7);
                    if (totalDays % 4 == 3) {
                        System.out.println(0);
                    } else if (thatDay.equals("Sunday") || thatDay.equals("Saturday")) {
                        System.out.println(50);
                    } else {
                        System.out.println(cal.get(Calendar.DAY_OF_YEAR)<= 50 ? cal.get(Calendar.DAY_OF_YEAR) : 50);
                    }

            } else {
                System.out.println("Invalid Date");
            }
        } else {
            System.out.println("Invalid Day");
        }
    }

    public static int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    private static boolean checkDateValidity(String date) {

        try {
                DateFormat df = new SimpleDateFormat(DATE_FORMAT);
                df.setLenient(false);
                df.parse(date);
                return true;
            } catch (ParseException e) {
                return false;
            }
    }

}



/*
    private static boolean checkDateValidity(String date) {
        String[] dates = date.split("/");
        int day = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        if((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day>=1 && day <=31) {
            return true;
        }
        if((month == 4 || month == 6 || month == 9 || month == 11) && day>=1 && day<=30) {
            return true;
        }
        if(month == 2) {

        }
    }
     <= 50 ? cal.get(Calendar.DAY_OF_YEAR) : 50
     */
