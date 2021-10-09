package com.btd.medium.longestcommonsubsequence;

/**
 * Leet Code - Medium - Problem 1143 - Longest Common Subsequence
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 * https://leetcode.com/problems/longest-common-subsequence/
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] matches = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i <= text1.length(); i++) {
            for (int j = 0; j <= text2.length(); j++) {
                if (i == 0 || j == 0) {
                    matches[i][j] = 0;
                } else {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        matches[i][j] = matches[i - 1][j - 1] + 1;
                    } else {
                        matches[i][j] = Math.max(matches[i - 1][j], matches[i][j - 1]);
                    }
                }
            }
        }

        return matches[text1.length()][text2.length()];
    }
}
