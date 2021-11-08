package com.btd.leetcode.medium.substringwithnonrepeatingcharacter;

/**
 * Leet Code - Medium - Problem 3 - Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating characters.
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String args[]) {
        String s = "abba";
        System.out.println(lengthOfLongestSubstring(s));
        s = "";
        System.out.println(lengthOfLongestSubstring(s));
        s = " ";
        System.out.println(lengthOfLongestSubstring(s));
        s = "acc";
        System.out.println(lengthOfLongestSubstring(s));
        s = "aca";
        System.out.println(lengthOfLongestSubstring(s));
        s = "acabc";
        System.out.println(lengthOfLongestSubstring(s));
        s = "acebc";
        System.out.println(lengthOfLongestSubstring(s));
        s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
        s = "wobgrovw";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {

        int result = 0;
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        int curlen = 0;
        int start = 0;
        for (int j = 0; j < s.length(); j++) {
            Character c = s.charAt(j);
            if (lastIndexMap.containsKey(c)) {
                int lastIndex = lastIndexMap.get(c);
                if (start < lastIndex) {
                    start = lastIndex;
                }
                curlen = j - start;
            } else {
                curlen++;
            }
            if (result < curlen) {
                result = curlen;
            }
            lastIndexMap.put(c, j);
        }

        return result;
    }
}
