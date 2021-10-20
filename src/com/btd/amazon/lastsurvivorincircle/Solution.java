package com.btd.amazon.lastsurvivorincircle;

public class Solution {

    //https://www.geeksforgeeks.org/josephus-problem-iterative-solution/
    // Method for finding the winning child.
    private static int josephus(int n, int k)
    {
        int sum = 0;

        // For finding out the removed
        // chairs in each iteration
        for(int i = 2; i <= n; i++)
        {
            sum = (sum + k) % i;
        }

        return sum+1;
    }

    // Driver Program to test above method
    public static void main(String[] args)
    {
        int n = 7;
        int k = 4;
        System.out.println(josephus(n, k));
    }
}
