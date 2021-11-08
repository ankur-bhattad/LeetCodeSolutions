package com.btd.salesforce.swapstosortarray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
public class Solution {
    public static void main(String args[]) {
        //int arr[] = {4, 3, 2, 1};
        int arr[] = {2, 4, 5, 1, 3};
        System.out.println(countNoOfSwapsToSort(arr));
    }

    private static int countNoOfSwapsToSort(int[] arr) {
        int temp[] = Arrays.copyOf(arr, arr.length);
        Arrays.sort(temp);
        int result = 0;
        Map<Integer, Integer> elementIndexMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            elementIndexMap.put(arr[i], i);
        }

        for (int i=0; i<arr.length; i++) {
            if (arr[i] != temp[i]) {
                result ++;
                int element = arr[i];
                int index = elementIndexMap.get(temp[i]);
                swap(arr, i, index);
                elementIndexMap.put(temp[i], i);
                elementIndexMap.put(element, index);
            }
        }
        return  result;

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
