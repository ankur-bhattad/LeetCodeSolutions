package com.btd.wordwrapsolutions.costeffectivewordwrap;

import java.util.Arrays;

/*
https://www.geeksforgeeks.org/word-wrap-problem-space-optimized-solution/
Input : arr[] = {3, 2, 2, 5}
Output : 1 1 2 3 4 4
Line number 1: From word no. 1 to 1
Line number 2: From word no. 2 to 3
Line number 3: From word no. 4 to 4

Input : arr[] = {3, 2, 2}
Output : 1 1 2 2 3 3
Line number 1: From word no. 1 to 1
Line number 2: From word no. 2 to 2
Line number 3: From word no. 3 to 3
 */
public class Solution {
    public static void main(String args[]) {
        int arr[] = {3,2,2,5};
        costEffectiveWordWrap(arr, arr.length, 6);
    }

    public static void costEffectiveWordWrap(int arr[], int n, int k) {

        int cost[] = new int[n];
        int lastIndex[] = new int[n];

        Arrays.fill(cost, Integer.MAX_VALUE);

        cost[n - 1] = 0;
        lastIndex[n - 1] = n - 1;

        for (int i = n - 2; i >= 0; i--) {

            int currentCost;
            int currentLen = -1;

            for (int j = i; j < n; j++) {
                currentLen += arr[j]+1;

                if (currentLen>k) {
                    break;
                }

                if (j == n-1) {
                    currentCost = 0;
                } else {
                    // very important line
                    // cost is square of extra spaces plus cost of putting line breaks in rest of words
                    // from j+1 to n-1.
                    currentCost = (k-currentLen)*(k-currentLen) + cost[j+1];
                }

                if (currentCost < cost[i]) {
                    cost[i] = currentCost;
                    lastIndex[i] = j;
                }
            }
        }

        int i=0;
        while (i<n) {
            System.out.println("word no: "+(i+1)+" to word no: "+(lastIndex[i]+1));
            i = lastIndex[i] + 1;
        }
    }
}
