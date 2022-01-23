package com.btd.leetcode.medium.reversepartlinkedlist;

/**
 * Leet Code - Medium - Problem 92 - Reverse Linked List II
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 */
public class Solution {

    class ListNode {
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

    public static void main(String args[]) {

    }

    //1->2->3->4->5
    // 2, 4
    //1->4->3->2->5

    //3->5
    // 1,2

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        int pos = 1;
        ListNode current = head;
        ListNode leftParent = null;

        while (pos < left) {
            leftParent = current;
            current = current.next;
            pos += 1;
        }

        ListNode prev = leftParent;
        ListNode oldLeft = current;
        for (int i = 1; i <= (right - left + 1); i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        oldLeft.next = current;
        if (leftParent != null) {
            leftParent.next = prev;
        } else {
            return prev;
        }

        return head;
    }
}
