package com.btd.medium.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leet Code - Medium - Problem 15 - 3Sum
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * https://leetcode.com/problems/3sum/
 */
public class Solution {

    public static void main(String args[]){
        int []nums = {-1,0,1,2,-1,-4};
        int []nums1 = {0,0,0};
        int []nums2 = {0,0,0,0};
        int []nums3 = {-2,0,0,2,2};
        System.out.println(threeSum(nums));
        System.out.println(threeSum(nums1));
        System.out.println(threeSum(nums2));
        System.out.println(threeSum(nums3));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length<3) {
            return result;
        }

        Arrays.sort(nums);
        for (int i=0; i<=nums.length-3; i++) {
            if (i>0 && nums[i]==nums[i-1]) {
                continue;
            }
            int j=i+1;
            int k=nums.length-1;

            while (j < k) {
                if(k<nums.length-1 && nums[k]==nums[k+1]){
                    k--;
                    continue;
                }
                if (nums[i]+nums[j]+nums[k] == 0) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    result.add(triplet);
                    j++;
                    k--;
                } else if (nums[i]+nums[j]+nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return result;
    }
}
