package com.btd.medium.generateparenthesis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leet Code - Medium - Problem 22 - Geenrate parenthesis
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * https://leetcode.com/problems/generate-parentheses/
 */
public class Solution {
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] str = new char[2 * n];
        generateParenthesisUtil(result, n, str, 0, 0, 0);
        return result;
    }

    private static void generateParenthesisUtil(List<String> result, int n, char[] str, int pos, int openBraceCount, int closeBraceCount) {
        if (closeBraceCount == n) {
            result.add(String.valueOf(str));
        } else {

            if (openBraceCount > closeBraceCount) {
                str[pos] = ')';
                generateParenthesisUtil(result, n, str, pos+1, openBraceCount, closeBraceCount+1);
            }

            if (openBraceCount < n) {
                str[pos] = '(';
                generateParenthesisUtil(result, n, str, pos+1, openBraceCount+1, closeBraceCount);
            }
        }
    }

    public static void main(String args[]) {
        System.out.println(generateParenthesis(2));
    }
}
