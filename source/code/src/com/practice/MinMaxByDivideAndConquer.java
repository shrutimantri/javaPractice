package com.practice;

/**
 * Created by shruti.mantri on 09/08/16.
 */
public class MinMaxByDivideAndConquer {
        public static int[] findMinMax(int[] array, int i, int j){
            // base cases
            int arrLen = j - i + 1;
            if (arrLen == 1)
                return new int[]{array[i], array[j]};    //j and i are the same

            if (arrLen == 2){
                int min = Math.min(array[i], array[j]);
                int max = Math.max(array[i], array[j]);
                return new int[]{min, max};
            }

            // actual divide and conquer
            int mid = i + (j-i)/2;
            int[] leftMinMax = findMinMax(array, i, mid);
            int[] rightMinMax = findMinMax(array, mid+1, j);
            return new int[]{  Math.min(leftMinMax[0], rightMinMax[0]), Math.max(leftMinMax[1], rightMinMax[1])   };
        }

        public static void main(String[] args){
            int[] array = {20, 5, 7, 25, 30, 1, 9, 12};
            int[] minMax= findMinMax(array, 0, array.length - 1);           //minMax[0] = minimum value, minMax[1] = maximum value
            System.out.println("min = " + minMax[0] + ", max = " + minMax[1] );
        }

}
