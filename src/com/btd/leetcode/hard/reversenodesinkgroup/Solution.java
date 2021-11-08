package com.btd.leetcode.hard.reversenodesinkgroup;

/**
 * Leet Code - Hard - Problem 25 - Reverse Nodes in k-Group
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes,
 * in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
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
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode start = head;
        ListNode first = new ListNode(-1);
        int count = 1;

        while (head != null) {
            first.next = swapKNodes(head, k);
            if (count == 1) {
                start = first.next;
            }
            if (first.next == head) {
                return start;
            }
            for (int i = 1; i <= k; i++) {
                first = first.next;
            }
            head = first.next;
            count++;
        }

        return start;
    }

    private static ListNode swapKNodes(ListNode head, int k) {
        ListNode start = head;
        for (int i = 1; i <= k; i++) {
            if (head == null) {
                return start;
            }
            head = head.next;
        }

        return reverseK(start, k);
    }

    private static ListNode reverseK(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        for (int i=1; i<=k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head.next = curr;

        return prev;
    }

    public static void main(String args[]) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        /*head1.next.next.next.next.next = new ListNode(6);*/

        ListNode newHead = reverseKGroup(head1, 5);
        while (newHead != null) {
            System.out.println(newHead.val);
            newHead = newHead.next;
        }
    }
}
