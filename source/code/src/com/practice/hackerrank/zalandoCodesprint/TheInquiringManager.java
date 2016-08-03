package com.practice.hackerrank.zalandoCodesprint;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheInquiringManager {

    public static void main(String[] args) {
        List<Long> output = new ArrayList<Long>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Order head = null;
        Order next = null;
        for(int i=0; i<n; i++) {
            int k = in.nextInt();
            if(k == 1) {
                long p = in.nextLong();
                long t = in.nextLong();
                Order temp = new Order(p, t);
                if(head == null){
                    head = temp;
                    next = head;
                }
                else {
                    next.setNextOrder(temp);
                    next = next.getNextOrder();
                }
            }
            else {

            }
        }
    }

    static class Order{
        private long price;
        private long minute;
        private Order nextOrder;

        public Order(long p, long t) {
            this.price = p;
            this.minute = t;
        }

        public long getPrice() {
            return price;
        }

        public void setPrice(long price) {
            this.price = price;
        }

        public long getMinute() {
            return minute;
        }

        public void setMinute(long minute) {
            this.minute = minute;
        }

        public Order getNextOrder() {
            return nextOrder;
        }

        public void setNextOrder(Order nextOrder) {
            this.nextOrder = nextOrder;
        }
    }
}
