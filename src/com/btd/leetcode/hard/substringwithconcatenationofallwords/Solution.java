package com.btd.leetcode.hard.substringwithconcatenationofallwords;

import java.util.*;

/**
 * Leet Code - Hard - Problem 30 - Substring with Concatenation of All Words
 * You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s)
 * in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.
 * You can return the answer in any order.
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class Solution {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indexes = new ArrayList<>();
        int noOfWords = words.length;
        int wordLength = words[0].length();

        if (s.length() < noOfWords * wordLength) {
            return indexes;
        }

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - (noOfWords * wordLength); i++) {
            if (s.substring(i).length() < noOfWords * wordLength) {
                return indexes;
            }
            Map<String, Integer> wordMap = new HashMap<>();
            int k = i;
            for (int j = 1; j <= noOfWords; j++) {
                String curWord = s.substring(k, k + wordLength);
                if (wordCount.containsKey(curWord)) {
                    wordMap.put(curWord, wordMap.getOrDefault(curWord, 0) + 1);
                    k = k + wordLength;
                } else {
                    break;
                }
            }
            if (wordCount.equals(wordMap)) {
                indexes.add(i);
            }
        }

        return indexes;

    }

    public static void main (String args[]) {
        /*String s = "barfoothefoobarman";
        String []words = {"foo","bar"};*/

        String s = "wordgoodgoodgoodbestword";
        String []words = {"word","good","best","good"};

        System.out.println(findSubstring(s, words));
    }

}
