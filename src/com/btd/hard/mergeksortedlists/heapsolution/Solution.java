package com.btd.hard.mergeksortedlists.heapsolution;

import java.util.Comparator;
import java.util.PriorityQueue;

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

        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }

        while (!heap.isEmpty()) {
            ListNode top = heap.peek();
            heap.remove();

            if (top.next != null) {
                heap.add(top.next);
            }

            if (head == null) {
                head = top;
                tail = top;
            } else {
                tail.next = top;
                tail = top;
            }
        }

        return head;
    }
}
