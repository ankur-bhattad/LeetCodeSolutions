package com.btd.ms.smallestnonotrepresentedbysubset;

// https://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/
/*
Given a sorted array (sorted in non-decreasing order) of positive numbers,
find the smallest positive integer value that cannot be represented as sum of
elements of any subset of given set.
Expected time complexity is O(n).
Input:  arr[] = {1, 3, 6, 10, 11, 15};
Output: 2

Input:  arr[] = {1, 1, 1, 1};
Output: 5

Input:  arr[] = {1, 1, 3, 4};
Output: 10

Input:  arr[] = {1, 2, 5, 10, 20, 40};
Output: 4

Input:  arr[] = {1, 2, 3, 4, 5, 6};
Output: 22
 */
public class Solution {
    public static void main (String args[]) {
        int arr[] = {1,2,5,10};
        int res = 1;
        for (int i=0; i<arr.length && arr[i] <= res; i++) {
            res += arr[i];
        }

        System.out.println(res);
    }
}
