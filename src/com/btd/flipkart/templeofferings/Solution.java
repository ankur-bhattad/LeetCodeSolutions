package com.btd.flipkart.templeofferings;


import java.util.Arrays;

/*
Given an array of integer representing heights of N temples.
We need to provide offerings to each temple in a way that
if the height if next temple is greater, offerings should be doubled
and if its lesser, offerings should be halved.
Find out the minimum total offering X and the offering at first temple Y.
E.G: [4, 10, 20, 17]
X = 9
Y = 1

 */
public class Solution {
    public static void main(String args[]) {
        int heights[] = {4, 10, 20, 17};
        templeOfferings(heights);

        int heights1[] = {4, 10, 17, 20};
        templeOfferings(heights1);

        int heights2[] = {14, 12, 10, 7};
        templeOfferings(heights2);

        int heights3[] = {10, 4, 17, 12};
        templeOfferings(heights3);

        int heights4[] = {10, 4, 17, 12, 5};
        templeOfferings(heights4);
    }

    private static void templeOfferings(int[] heights) {
        int n = heights.length;
        int left[] = new int[n];
        int right[] = new int[n];

        Arrays.fill(left, -1);
        Arrays.fill(right, -1);

        left[0] = 1;
        right[n-1] = 1;

        for (int i =1; i<n; i++) {
            if (heights[i]>heights[i-1]) {
                left[i] = left[i-1] * 2;
            } else if (heights[i]<heights[i-1]) {
                left[i] = left[i-1]/2;
            } else {
                left[i] = left[i-1];
            }
        }

        for (int i = n-2; i>= 0; i--) {
            if (heights[i+1]>heights[i]) {
                right[i] = right[i+1] / 2;
            } else if (heights[i+1]<heights[i]) {
                right[i] = right[i+1]*2;
            } else {
                right[i] = right[i+1];
            }
        }

        int sum = 0;
        for (int i=0; i<n; i++) {
            sum += Math.max(left[i], right[i]);
        }

        System.out.println("X= "+sum+", Y="+Math.max(left[0], right[0]));
    }
}
