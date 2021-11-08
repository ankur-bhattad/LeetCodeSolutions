package com.btd.leetcode.medium.mergetwosortedlists;

/**
 * Leet Code - Medium - Problem 21 - Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class Solution {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return  l2;
        }
    }

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
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next =  new ListNode(5);

        // 1.3.5 LinkedList created

        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(4);

        // 0.2.4 LinkedList created

        ListNode mergedhead = mergeTwoLists(head1, head2);

        while (mergedhead != null) {
            System.out.println(mergedhead.val);
            mergedhead = mergedhead.next;
        }
    }
}
