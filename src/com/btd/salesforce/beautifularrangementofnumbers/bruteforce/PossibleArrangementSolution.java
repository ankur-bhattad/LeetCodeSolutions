package com.btd.salesforce.beautifularrangementofnumbers.bruteforce;

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
        int n = 3;

        // brute force recursive
        printPsblBeautifulArrangements(n);
    }

    private static void printPsblBeautifulArrangements(int n) {

        int arr[] = new int[n];
        for (int i = 1; i <= n; i++) {
            printPsblBeautifulArrangementsUtil(arr, i, n, 0);
        }
    }

    private static void printPsblBeautifulArrangementsUtil(int[] arr, int currentNumber, int n, int currentIndex) {

        if ((currentIndex + 1) % currentNumber == 0 || currentNumber % (currentIndex + 1) == 0) {
            arr[currentIndex] = currentNumber;

            if (currentIndex == n - 1) {
                printArray(arr);
                return;
            }
            for (int i = 1; i <= n; i++) {
                if (doesNotContains(arr, currentIndex, i)) {
                    printPsblBeautifulArrangementsUtil(arr, i, n, currentIndex + 1);
                }
            }
        }
    }

    private static boolean doesNotContains(int[] arr, int index, int number) {
        for (int i = 0; i <= index; i++) {
            if (arr[i] == number) {
                return false;
            }
        }
        return true;
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }
}
