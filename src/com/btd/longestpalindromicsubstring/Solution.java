package com.btd.longestpalindromicsubstring;

/**
 * Leet Code - Medium - Problem 5 - Longest Palindromic Substring
 * Given a string s, return the longest palindromic substring in s.
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 */
public class Solution {

    public String longestPalindrome(String s) {
        int maxLen = 1;
        int finalStart = 0;
        int finalEnd = 0;

        int start = 0;
        int end = 0;
        int curLen = 1;

        for (int i = 1; i<s.length(); i++) {

            // form odd length palindromes with i as center
            curLen = 1;
            start = i-1;
            end = i+1;

            while (start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                curLen += 2;

                if (maxLen < curLen) {
                    maxLen = curLen;
                    finalStart = start;
                    finalEnd = end;
                }

                start --;
                end ++;
            }

            // form even length palindromes with i as center
            curLen = 0;
            start = i-1;
            end = i;

            while (start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                curLen += 2;

                if (maxLen < curLen) {
                    maxLen = curLen;
                    finalStart = start;
                    finalEnd = end;
                }

                start --;
                end ++;
            }

        }
        return s.substring(finalStart, (finalEnd+1));
    }
}
