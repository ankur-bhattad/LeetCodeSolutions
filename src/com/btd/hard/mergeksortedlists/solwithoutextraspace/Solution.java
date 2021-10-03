package com.btd.hard.mergeksortedlists.solwithoutextraspace;

/**
 * Leet Code - Medium - Problem 23 - Merge k Sorted Lists
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        return mergeKListsUtil(lists, lists.length - 1);
    }

    // pair two lists at a time and keep doing it till you have only 1 list
    // refer https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/
    private static ListNode mergeKListsUtil(ListNode[] lists, int last) {
        while (last != 0) {
            int i = 0;
            int j = last;

            //i and j form a pair
            while (i < j) {

                //merge i And j
                lists[i] = sort(lists[i], lists[j]);

                //consider next pair
                i++;
                j--;

                // If all pairs are merged, update last
                if (i >= j) {
                    last = j;
                }
            }
        }
        return lists[0];
    }

    private static ListNode sort(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = sort(list1.next, list2);
            return list1;
        } else {
            list2.next = sort(list1, list2.next);
            return list2;
        }
    }
}
