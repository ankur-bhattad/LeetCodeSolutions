package com.btd.wallmart;

// Given a Binary Tree, print all nodes that don’t have a sibling.
/*
         1
     2      3
   4           5
 */
public class Solution {
    public static void main(String args[]) {


    }

    public static void printNodesWithoutSiblings(Node root) {
        printNodesWithoutSiblingsUtil(root, null);
    }

    private static void printNodesWithoutSiblingsUtil(Node root, Node parent) {
        if (root == null) {
            return;
        }

        if (parent != null) {
            if (parent.leftChild == root && parent.rightChild==null) {
                System.out.println(root.data);
            }
            if (parent.rightChild == root && parent.leftChild == null) {
                System.out.println(root.data);
            }
        }

        printNodesWithoutSiblingsUtil(root.leftChild, root);
        printNodesWithoutSiblingsUtil(root.rightChild, root);
    }

    class Node {
        int data;
        Node leftChild;
        Node rightChild;

        public Node(int data) {
            this.data = data;
        }
    }
}
