package com.btd.salesforce.beautifularrangementofnumbers.usingbasearray;

/*
1. Given a number n, print all possible beautiful arrangements of number from 1 to n.


Beautiful arrangement: either index(1 based index) divisible by number at that index or number divisible by index at which it is present
E.G: n=4,

1,2,3,4
1,4,3,2
2,1,3,4
2,4,3,1
3,2,1,4
3,4,1,2
4,1,3,2
4,2,3,1

E.G: n=5,

1,2,3,4,5
1,4,3,2,5
2,1,3,4,5
2,4,3,1,5
3,2,1,4,5
3,4,1,2,5
5,2,3,4,1
5,4,3,2,1
4,2,3,1,5
4,1,3,2,5

 */
public class PossibleArrangementSolution {

    public static void main(String[] args) {
        int n = 5;

        // brute force recursive
        printPsblBeautifulArrangements(n);
    }

    private static void printPsblBeautifulArrangements(int n) {
        int arr[] = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = i+1;
        }

        printPsblBeautifulArrangementsUtil(arr, 0, n-1);
    }

    private static void printPsblBeautifulArrangementsUtil(int[] arr, int l, int r) {
        if (l==r) {
            printArray(arr);
        }

        for (int i = l; i<=r; i++) {
            if (((l+1) % arr[i] == 0 || arr[i] % (l+1) == 0) && ((i+1) % arr[l] == 0 || arr[l] % (i+1) == 0)) {
                swap(arr, l, i);
                printPsblBeautifulArrangementsUtil(arr, l+1, r);
                swap(arr, i, l);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
