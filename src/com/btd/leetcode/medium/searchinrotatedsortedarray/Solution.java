package com.btd.leetcode.medium.searchinrotatedsortedarray;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
 * such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
 * or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class Solution {
    public static int search(int[] nums, int target) {
        return searchUtil(nums, 0, nums.length - 1, target);
    }

    private static int searchUtil(int[] nums, int l, int r, int target) {
        if (l > r) {
            return -1;
        }

        int mid = (l + r) / 2;

        if (target == nums[mid]) {
            return mid;
        }

        if (nums[mid] >= nums[l]) {
            if (target >= nums[l] && target <= nums[mid]) {
                return searchUtil(nums, l, mid-1, target);
            } else {
                return searchUtil(nums, mid + 1, r, target);
            }
        }

        if (target >= nums[mid] && target <= nums[r]) {
            return searchUtil(nums, mid + 1, r, target);
        }

        return searchUtil(nums, l, mid-1, target);
    }

    public static void main(String args[]) {
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 0));
        System.out.println(search(nums, 3));

        int nums1[] = {1};
        System.out.println(search(nums1, 0));

        int nums2[] = {3,1};
        System.out.println(search(nums2, 1));
    }

}
