package com.btd.ms.maxprofitbytradingintwocities;

//https://leetcode.com/discuss/interview-question/762690/google-telephone-interview-coding-question
/*
G- You are a traveling salesperson who travel back and forth between two cities X and Y.
- You are given with pair of arrays with selling price at each city (sp_X and sp_Y) each of length 'n' such that:
	- sp_X[i] =  selling-price of goods in city X on day i;
	- sp_Y[i] =  selling-price of goods in city Y on day i;
- You can only sell goods in one city per day.
- At the end of the day, you can choose to travel to another city but it will cost a constant amount of money (cost).

Given these inputs, write a function which will return the maximum profit attainable from some schedule in which each day
is spent in one of the two cities

profit  = (selling_price - travel-cost)
 */
public class Solution {
    public static void main(String args[]) {
        int cityA[] = {1,2,3, 100};
        int cityB[] = {2,4,0, 2};
        int cost = 2;
        System.out.println(maximumProfit(cityA, cityB, cost));
    }
    
    public static int maximumProfit(int cityA[], int cityB[], int cost) {
        int maxA = cityA[0];
        int maxB = cityB[0];
        
        for (int i=1; i<cityA.length; i++) {
            maxA = Math.max(maxA+cityA[i], maxB+cityA[i]-cost);
            maxB = Math.max(maxB+cityB[i], maxA+cityB[i]-cost);
        }
        
        return  Math.max(maxA, maxB);
    }
}
