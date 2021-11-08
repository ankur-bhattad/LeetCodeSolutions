package com.btd.informatica.leftviewandskeleton;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String args[]) {
        Node node1 = new Node(7);
        Node node2 = new Node(4);
        Node node3 = new Node(3);
        Node node4 = new Node(9);
        Node node5 = new Node(1);
        Node node6 = new Node(1);
        Node node7 = new Node(1);
        Node node8 = new Node(22);
        Node node9 = new Node(2);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;

        printLeftView(node1);
        printLeftViewUsingLevelOrderTraversal(node1);
        printSkeleton(node1);
    }

    /*
            7
          /   \
         4     3
        / \   / \
       9  1  1   1
	     / \
         22 2

output: 7, 4, 9, 22, 3, 1
 */

    private static void printLeftView(Node root) {
        System.out.println("Left View using recursion");
        leftViewUtil(root, 1, 0);
    }

    private static int leftViewUtil(Node root, int currentLevel, int maxLevelTraversed) {
        if (root == null) {
            return maxLevelTraversed;
        }

        if (maxLevelTraversed < currentLevel) {
            maxLevelTraversed = currentLevel;
            System.out.println(root.data);
        }

        maxLevelTraversed = leftViewUtil(root.left, currentLevel + 1, maxLevelTraversed);
        maxLevelTraversed = leftViewUtil(root.right, currentLevel + 1, maxLevelTraversed);
        return maxLevelTraversed;
    }

    private static void printLeftViewUsingLevelOrderTraversal(Node root) {
        System.out.println("Left View using Level order traversal");

        if (root == null) {
            return;
        }

        Queue<Node> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);

        while (!bfsQueue.isEmpty()) {
            int levelSize = bfsQueue.size();
            for (int i = 1; i <= levelSize; i++) {
                Node current = bfsQueue.poll();
                if (i == 1) {
                    System.out.println(current.data);
                }
                if (current.left != null) {
                    bfsQueue.add(current.left);
                }
                if (current.right != null) {
                    bfsQueue.add(current.right);
                }
            }
        }
    }

    public static void printSkeleton(Node root) {
        System.out.println("Skeleton using Level order traversal: Left and Right view");
        if (root == null) {
            return;
        }

        Queue<Node> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);

        while (!bfsQueue.isEmpty()) {
            int levelSize = bfsQueue.size();
            for (int i = 1; i <= levelSize; i++) {
                Node current = bfsQueue.poll();
                if (i == 1 || i==levelSize) {
                    System.out.println(current.data);
                }
                if (current.left != null) {
                    bfsQueue.add(current.left);
                }
                if (current.right != null) {
                    bfsQueue.add(current.right);
                }
            }
        }
    }
}
