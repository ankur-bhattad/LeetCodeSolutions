package com.btd.salesforce.beautifularrangementofnumbers.usingbasearray;

public class CountOfArrangements {
    public static void main(String[] args) {
        int n = 5;

        // brute force recursive
        System.out.println(countOfBeautifulArrangements(n));
    }

    private static int countOfBeautifulArrangements(int n) {
        int arr[] = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = i+1;
        }

        return countOfBeautifulArrangementsUtil(arr, 0, n-1, 0);
    }

    private static int countOfBeautifulArrangementsUtil(int[] arr, int l, int r, int count) {
        if (l==r) {
            return count+1;
        }

        for (int i = l; i<=r; i++) {
            if (((l+1) % arr[i] == 0 || arr[i] % (l+1) == 0) && ((i+1) % arr[l] == 0 || arr[l] % (i+1) == 0)) {
                swap(arr, l, i);
                count = countOfBeautifulArrangementsUtil(arr, l+1, r, count);
                swap(arr, i, l);
            }
        }
        return count;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
