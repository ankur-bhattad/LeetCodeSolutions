package com.btd.leetcode.hard.wordsearchII;

import java.util.*;

/**
 * Leet Code - Hard - Problem 212 - Word Search II
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 * <p>
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
 *        words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * https://leetcode.com/problems/word-search-ii/
 */
public class Solution {

    public static List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode(null);
        for (int i = 0; i < words.length; i++) {
            insert(root, words[i]);
        }
        Set<String> result = new HashSet<>();
        int r = board.length;
        int c = board[0].length;
        boolean visited[][] = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (root.node.containsKey(board[i][j])) {
                    find(result, "", root.node.get(board[i][j]), board, i, j, visited);
                }
            }
        }

        return new ArrayList<>(result);
    }

    private static void find(Set<String> result, String str, TrieNode root, char[][] board, int i, int j, boolean visited[][]) {
        str = str + board[i][j];
        visited[i][j] = true;
        if (root.isLeaf) {
            result.add(str);
        }

        if (isSafe(i + 1, j, visited) && root.node.containsKey(board[i + 1][j])) {
            find(result, str, root.node.get(board[i+1][j]), board, i + 1, j, visited);
        }

        if (isSafe(i - 1, j, visited) && root.node.containsKey(board[i - 1][j])) {
            find(result, str, root.node.get(board[i-1][j]), board, i - 1, j, visited);
        }

        if (isSafe(i, j + 1, visited) && root.node.containsKey(board[i][j + 1])) {
            find(result, str, root.node.get(board[i][j+1]), board, i, j + 1, visited);
        }

        if (isSafe(i, j - 1, visited) && root.node.containsKey(board[i][j - 1])) {
            find(result, str, root.node.get(board[i][j-1]), board, i, j - 1, visited);
        }

        visited[i][j] = false;
    }

    private static boolean isSafe(int i, int j, boolean[][] visited) {
        if ((i >= 0 && i < visited.length) && (j >= 0 && j < visited[0].length) && !visited[i][j]) {
            return true;
        }
        return false;
    }


    private static void insert(TrieNode root, String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        int i = 0;
        while (i < word.length()) {
            char c = word.charAt(i);
            if (!root.node.containsKey(c)) {
                root.node.put(c, new TrieNode(c));
            }
            root = root.node.get(c);
            i++;
        }
        root.isLeaf = true;
    }

    static class TrieNode {
        Character c;
        Map<Character, TrieNode> node;
        boolean isLeaf;

        public TrieNode(Character c) {
            this.c = c;
            node = new HashMap<>();
        }
    }

    public static void main(String atgs[]) {
        char[][] board = {{'o', 'a', 'b', 'n'},
                {'o', 't', 'a', 'e'},
                {'a', 'h', 'k', 'r'},
                {'a', 'f', 'l', 'v'}};
        String[] words = {"oa", "oaa"};

        /*char[][] board = {{'a', 'b'},
                {'c', 'd'}};
        String[] words = {"abdc"};*/

        System.out.println(findWords(board, words));
    }
}
