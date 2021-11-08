package com.btd.paypal.quadruplets;


import java.util.HashMap;
import java.util.Map;

//https://www.geeksforgeeks.org/find-four-elements-that-sum-to-a-given-value-set-2/
public class Solution {
    public static void main(String args[]) {
        int arr[] = {10, 20, 30, 40, 1, 2};
        int target = 91;
        findQuadruplets(arr, target);
    }

    private static void findQuadruplets(int[] arr, int target) {
        int length = arr.length;
        Map<Integer, Pair> sumMap = new HashMap<>();
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                sumMap.put(arr[i] + arr[j], new Pair(i, j));
            }
        }

        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int sum = arr[i] + arr[j];
                if (sumMap.containsKey(target - sum)) {
                    Pair targetPair = sumMap.get(target - sum);
                    if (targetPair.first != i && targetPair.first != j
                            && targetPair.second != i && targetPair.second != j) {
                        System.out.println(arr[i] + ", " + arr[j] + ", " + arr[targetPair.first] + ", " + arr[targetPair.second]);
                        return;
                    }
                }
            }
        }
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
