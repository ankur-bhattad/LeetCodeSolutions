package com.btd.leetcode.medium.removenthnodefromendoflist;

/**
 * Leet Code - Medium - Problem 19 - Remove Nth Node From End of List
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
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

    public static void main(String args[]) {
        /*ListNode five = new ListNode(5, null);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);*/

        ListNode one = new ListNode(1, null);

        ListNode head = removeNthFromEnd(one, 1);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        ListNode prev = null;

        for (int i = 2; i <= n; i++) {
            second = second.next;
        }

        while (second.next != null) {
            prev = first;
            first = first.next;
            second = second.next;
        }

        if (prev != null) {
            prev.next = first.next;
            return head;
        }

        return head.next;
    }
}
