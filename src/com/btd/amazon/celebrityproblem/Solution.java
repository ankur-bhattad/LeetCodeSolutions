package com.btd.amazon.celebrityproblem;

// https://www.geeksforgeeks.org/the-celebrity-problem/
public class Solution {
    public static void main(String[] args) {
        String[] celebs = {"a", "b", "c"};
        System.out.println(findCelebrity(celebs));
    }

    private static String findCelebrity(String[] celebs) {

        if (celebs.length <= 1) {
            return null;
        }
        int i = 0;
        int j = celebs.length-1;

        while (i < j) {
            // if j knows i
            if (knows(i, j)) {
                j--;
            } else {
                i++;
            }
        }

        // i is celebrity if it meets criteria that he knows no one and everyone else knows him
        int count = 0;
        for (int k = 0; k < celebs.length; k++) {
            if (k != i) {
                if (knows(i, k) || !knows(k, i)) {
                    break;
                } else {
                    count++;
                }
            }
        }

        if (count == celebs.length - 1) {
            return celebs[i];
        }

        return  null;
    }

    private static boolean knows(int i, int j) {
        // C is celebrity
        int [][] familiarityMatrix = { {0, 0, 1}, {1, 0, 1}, {0, 0, 0}};
        if (familiarityMatrix[i][j] == 1) {
            return true;
        }
        return false;
    }
}
