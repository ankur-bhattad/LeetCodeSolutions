package com.btd.leetcode.medium.addtwonumbersaslinkedlist;

/**
 * Leet Code - Medium - Problem 2 - Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * https://leetcode.com/problems/add-two-numbers/
 */

class ListNode {
    public int val;
    public ListNode next;

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

    public static void main (String args[]) {

    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carryOver = 0;
        int sum = 0;
        ListNode prevNode = null;
        int i = 0;
        ListNode firstNode = null;
        while (l1 != null && l2 != null) {
            int valOne = l1.val;
            int valTwo = l2.val;

            sum = valOne + valTwo + carryOver;
            if (sum > 9) {
                carryOver = sum / 10;
                sum = sum % 10;
            } else {
                carryOver = 0;
            }

            ListNode newNode = new ListNode(sum);
            if (i == 0) {
                firstNode = newNode;
                i++;
            }
            if (prevNode != null) {
                prevNode.next = newNode;
            }
            prevNode = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l2 != null) {
            int valTwo = l2.val;

            sum = valTwo + carryOver;
            if (sum > 9) {
                carryOver = sum / 10;
                sum = sum % 10;
            } else {
                carryOver = 0;
            }

            ListNode newNode = new ListNode(sum);
            if (prevNode != null) {
                prevNode.next = newNode;
            }
            prevNode = newNode;
            l2 = l2.next;
        }

        while (l1 != null) {
            int valOne = l1.val;

            sum = valOne + carryOver;
            if (sum > 9) {
                carryOver = sum / 10;
                sum = sum % 10;
            } else {
                carryOver = 0;
            }

            ListNode newNode = new ListNode(sum);
            if (prevNode != null) {
                prevNode.next = newNode;
            }
            prevNode = newNode;
            l1 = l1.next;
        }

        if (carryOver > 0) {
            ListNode newNode = new ListNode(carryOver);
            if (prevNode != null) {
                prevNode.next = newNode;
            }
        }

        return firstNode;
    }
}
