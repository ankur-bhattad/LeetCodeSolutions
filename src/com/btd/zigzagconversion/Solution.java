package com.btd.zigzagconversion;

/**
 * Leet Code - Medium - Problem 6 - Zigzag conversion
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */

public class Solution {

    public static void main(String args[]) {
        System.out.println(convert("AB", 1));
    }

    public static String convert(String s, int numRows) {
        // 2*(n-1)
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        StringBuilder result = new StringBuilder();
        int curr = 0;
        for (int i=0; i<numRows; i++) {
            curr = i;
            boolean down = true;
            while (curr < len) {
                result.append(s.charAt(curr));
                if (i ==0 || i == numRows-1) {
                    curr += 2*(numRows-1);
                } else if (down) {
                    curr += 2*(numRows-i-1);
                    down = !down;
                } else if (!down) {
                    curr += 2*i;
                    down = !down;
                }
            }
        }
        return result.toString();
    }
}
