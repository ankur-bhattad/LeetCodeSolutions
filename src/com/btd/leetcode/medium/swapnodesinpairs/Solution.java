package com.btd.leetcode.medium.swapnodesinpairs;

/**
 * Leet Code - Medium - Problem 24 - Swap Nodes in Pairs
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes
 * (i.e., only nodes themselves may be changed.)
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
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

class Solution {
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode start = head.next;
        ListNode first = new ListNode(-1);

        while (head != null) {
            first.next = swap(head);
            first = head;
            head = head.next;
        }

        return start;
    }

    private static ListNode swap(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = next.next;
        next.next = head;
        return next;
    }

    public static void main(String args[]) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);



        ListNode newHead = swapPairs(head1);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
