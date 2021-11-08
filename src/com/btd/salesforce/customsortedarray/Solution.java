package com.btd.salesforce.customsortedarray;

// Given an array, tell minimum no of swaps to make it custom sorted array such that all even comes first,
// followed by odds
public class Solution {
    public static void main(String args[]) {
        int arr[] = {1, 2, 4, 8, 3, 5, 6, 7};
        int swaps = 0;

        int i = 0;
        int j = arr.length - 1;

        while (i <= j) {
            while (arr[i] % 2 == 0) {
                i++;
            }
            while (arr[j] % 2 != 0) {
                j--;
            }
            if (i<j) {
                swap(arr, i, j);
                swaps ++;
            }
        }

        System.out.println(swaps);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
