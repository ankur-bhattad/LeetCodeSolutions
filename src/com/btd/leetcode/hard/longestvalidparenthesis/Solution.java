package com.btd.leetcode.hard.longestvalidparenthesis;

import java.util.Stack;

/*
https://leetcode.com/problems/longest-valid-parentheses/
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

solution: https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
 */

public class Solution {

    public static void main(String args[]) {
        System.out.println(longestValidParenthesis("(()"));
        System.out.println(longestValidParenthesis("(())"));
        System.out.println(longestValidParenthesis(")()())"));
        System.out.println(longestValidParenthesis("()(()"));
    }

    public static int longestValidParenthesis(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        //base case
        stack.push(-1);

        int maxLength = 0;
        int curLength;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    curLength = i-stack.peek();
                    if (curLength > maxLength) {
                        maxLength = curLength;
                    }
                } else {
                    stack.push(i);
                }
            }
        }
        return maxLength;
    }
}
