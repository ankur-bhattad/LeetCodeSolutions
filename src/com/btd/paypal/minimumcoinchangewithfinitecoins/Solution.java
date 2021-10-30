package com.btd.paypal.minimumcoinchangewithfinitecoins;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * Bottom up way of solving this problem.
     * Keep input sorted. Otherwise temp[j-arr[i]) + 1 can become Integer.Max_value + 1 which
     * can be very low negative number
     * Returns Integer.MAX_VALUE - 1 if solution is not possible.
     */
    public static int minimumCoinBottomUp(int total, Map<Integer, Integer> coinMap) {
        int T[] = new int[total + 1];
        int R[] = new int[total + 1];
        T[0] = 0;

        for (int i = 1; i <= total; i++) {
            T[i] = Integer.MAX_VALUE - 1;
            R[i] = -1;
        }

        Integer[] coins = new Integer[coinMap.size()];
        coins = coinMap.keySet().toArray(coins);
        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i <= total; i++) {
                if (i >= coins[j] && coinMap.get(coins[j])>0) {
                    if (T[i - coins[j]] + 1 < T[i]) {
                        if (R[i] != -1) {
                            coinMap.put(coins[R[i]], coinMap.get(coins[R[i]])+1);
                        }
                        T[i] = 1 + T[i - coins[j]];
                        R[i] = j;
                        coinMap.put(coins[j], coinMap.get(coins[j])-1);
                    }
                }
            }
        }
        printCoinCombination(R, coins);
        return T[total];
    }

    private static void printCoinCombination(int R[], Integer coins[]) {
        if (R[R.length - 1] == -1) {
            System.out.print("No solution is possible");
            return;
        }
        int start = R.length - 1;
        System.out.print("Coins used to form total ");
        while (start != 0) {
            int j = R[start];
            System.out.print(coins[j] + " ");
            start = start - coins[j];
        }
        System.out.print("\n");
    }

    public static void main(String args[]) {
        int total = 49;

        Map<Integer, Integer> coinMap = new HashMap<>();
        coinMap.put(10, 3);
        coinMap.put(5, 5);
        coinMap.put(2, 3);
        coinMap.put(1, 3);

        int bottomUpValue = minimumCoinBottomUp(total, coinMap);

        System.out.print(String.format("Coin change result %s", bottomUpValue));

    }
}
