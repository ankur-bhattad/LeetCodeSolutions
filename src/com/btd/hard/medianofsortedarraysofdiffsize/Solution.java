package com.btd.hard.medianofsortedarraysofdiffsize;

/**
 * Leet Code - Hard - Problem 4 - Median of Two Sorted Arrays
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays. *
 * The overall run time complexity should be O(log (m+n)).
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n > m)
            return findMedianSortedArrays(nums2, nums1); // Swapping to make A smaller

        int start = 0;
        int end = n;
        int realmidinmergedarray = (n + m + 1) / 2;

        while (start <= end) {
            int mid = (start + end) / 2;
            int leftAsize = mid;
            int leftBsize = realmidinmergedarray - mid;
            int leftA
                    = (leftAsize > 0)
                    ? nums1[leftAsize - 1]
                    : Integer.MIN_VALUE; // checking overflow of indices
            int leftB
                    = (leftBsize > 0) ? nums2[leftBsize - 1] : Integer.MIN_VALUE;
            int rightA
                    = (leftAsize < n) ? nums1[leftAsize] : Integer.MAX_VALUE;
            int rightB
                    = (leftBsize < m) ? nums2[leftBsize] : Integer.MAX_VALUE;

            // if correct partition is done
            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0)
                    return (Math.max(leftA, leftB)
                            + Math.min(rightA, rightB))
                            / 2.0;
                return Math.max(leftA, leftB);
            }
            else if (leftA > rightB) {
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        return 0.0;
    }
}
