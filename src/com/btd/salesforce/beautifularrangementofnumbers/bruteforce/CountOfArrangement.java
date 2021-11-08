package com.btd.salesforce.beautifularrangementofnumbers.bruteforce;

/*
2. Given a number n, return No of possible beautiful arrangements of number from 1 to n.

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
public class CountOfArrangement {
    public static void main(String[] args) {
        int n = 4;

        // brute force recursive
        System.out.println(countBeautifulArrangements(n));
    }

    private static int countBeautifulArrangements(int n) {
        int count = 0;
        int arr[] = new int[n];
        for (int i = 1; i <= n; i++) {
            count = countBeautifulArrangementsUtil(arr, i, n, 0, count);
        }
        return count;
    }

    private static int countBeautifulArrangementsUtil(int[] arr, int currentNumber, int n, int currentIndex, int count) {

        if ((currentIndex + 1) % currentNumber == 0 || currentNumber % (currentIndex + 1) == 0) {
            arr[currentIndex] = currentNumber;

            if (currentIndex == n - 1) {
                count++;
                return count;
            }
            for (int i = 1; i <= n; i++) {
                if (doesNotContains(arr, currentIndex, i)) {
                    count = countBeautifulArrangementsUtil(arr, i, n, currentIndex + 1, count);
                }
            }
        }
        return count;
    }

    private static boolean doesNotContains(int[] arr, int index, int number) {
        for (int i = 0; i <= index; i++) {
            if (arr[i] == number) {
                return false;
            }
        }
        return true;
    }
}
