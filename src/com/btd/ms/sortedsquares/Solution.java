package com.btd.ms.sortedsquares;


/*
    Given a sorted array of positive and negative integers.
    Create a new output array of their squares, sorted in O(n) time
    Input: [-9, -3, 1, 2, 4, 6, 8, 10]
    Output: [1,4,9,16,36,64,81,100]
 */
public class Solution {
    public static void main(String args[]) {
        int arr[] = {-9, -3, 1, 2, 4, 6, 8, 10};
        printSortSquares(arr);
    }

    private static void printSortSquares(int[] arr) {
        int sortedSquares[] = new int[arr.length];
        int i = 0, j = arr.length - 1;
        for (int k = arr.length - 1; k >= 0; k--) {
            int firstSquare = (int) Math.pow(arr[i], 2);
            int secSquare = (int) Math.pow(arr[j], 2);
            if (firstSquare > secSquare) {
                sortedSquares[k] = firstSquare;
                i++;
            } else {
                sortedSquares[k] = secSquare;
                j--;
            }
        }

        for (i=0; i< arr.length; i++) {
            System.out.println(sortedSquares[i]);
        }
    }
}
