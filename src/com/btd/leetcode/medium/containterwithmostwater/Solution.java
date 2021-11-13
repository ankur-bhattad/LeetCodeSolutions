package com.btd.leetcode.medium.containterwithmostwater;

/**
 * Leet Code - Medium - Problem 11 - Container with most water
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that
 * the two endpoints of the line i is at (i, ai) and (i, 0).
 * Find two lines, which, together with the x-axis forms a container,
 * such that the container contains the most water.
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * https://leetcode.com/problems/container-with-most-water/
 */
public class Solution {

    public static  void main(String args[]) {
        // int []height = {1,8,6,2,5,4,8,3,7};
        // int []height = {1,1};
        // int []height = {4,3,2,1,4};
        // int []height = {1,2,1};
        int []height = {1,3,2,5,25,24,5};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int maxVolume = 0;
        int currVolume = 0;

        int i=0;
        int j=height.length-1;

        while (i<j) {
            currVolume = (j-i)*(Math.min(height[i], height[j]));
            if (currVolume > maxVolume) {
                maxVolume = currVolume;
            }
            if (height[i]<height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxVolume;
    }
    
}
