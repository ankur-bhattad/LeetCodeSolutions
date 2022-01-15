package com.btd.wallmart;

/*
Given an array of characters where each character represents a fruit tree, you are given two baskets,
and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.
You can start with any tree, but you can’t skip a tree once you have started. You will pick one fruit from each tree until you cannot, i.e.,
you will stop when you have to pick from a third fruit type.

Write a function to return the maximum number of fruits in both baskets.

Input: Fruit=['A', 'B', b, 'C', 'A', 'C']
Output: 3

Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 */

import java.util.Stack;

public class SolutionTwo {
    public static void main(String args[]) {

    }

    public static int getMaximumFruits(char fruits[]) {
        Stack<Character> basketOne = new Stack<>();
        Stack<Character> basketTwo = new Stack<>();

        int globalMax = 0;
        int currentMax = 0;

        for (int i=0;i<fruits.length; i++) {
            if (basketOne.isEmpty()) {
                basketOne.push(fruits[i]);
                currentMax += 1;
            } else if (basketOne.peek() == fruits[i]) {
                basketOne.push(fruits[i]);
                currentMax += 1;
            } else if (basketTwo.isEmpty()) {
                basketTwo.push(fruits[i]);
                currentMax += 1;
            } else if (basketTwo.peek() == fruits[i]) {
                basketTwo.push(fruits[i]);
                currentMax += 1;
            } else {
                
            }

            if (currentMax > globalMax) {
                globalMax = currentMax;
            }
        }
        return  globalMax;
    }
}
