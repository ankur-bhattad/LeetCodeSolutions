package com.btd.leetcode.medium.minesweeper;

/*
Leet Code - medium - 529. Minesweeper
https://leetcode.com/problems/minesweeper/

Input: board = [["E","E","E","E","E"],["E","E","M","E","E"],["E","E","E","E","E"],["E","E","E","E","E"]],
click = [3,0]
Output: [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]

Input: board = [["B","1","E","1","B"],["B","1","M","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]], click = [1,2]
Output: [["B","1","E","1","B"],["B","1","X","1","B"],["B","1","1","1","B"],["B","B","B","B","B"]]
 */
public class Solution {

    public static void main(String args[]) {

        /*char[][] board = {{'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int click[] = {3, 0};

        updateBoard(board, click);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("After second click");
        click = new int[]{1, 2};
        updateBoard(board, click);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }*/

        char[][] board1 = {{'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'M'},
                {'E', 'E', 'M', 'E', 'E', 'E', 'E', 'E'},
                {'M', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'M', 'E', 'E', 'E', 'E'}};
        int click2[] = {0, 0};
        updateBoard(board1, click2);

        for (int i = 0; i < board1.length; i++) {
            for (int j = 0; j < board1[i].length; j++) {
                System.out.print(board1[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static char[][] updateBoard(char[][] board, int[] click) {
        int clickRow = click[0];
        int clickColumn = click[1];
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != 'M' && board[i][j] != 'E') {
                    visited[i][j] = true;
                }
            }
        }
        return updateBoardUtil(board, visited, clickRow, clickColumn);
    }

    private static char[][] updateBoardUtil(char[][] board, boolean[][] visited, int clickRow, int clickColumn) {
        if (!visited[clickRow][clickColumn]) {

            int rows = board.length;
            int cols = board[0].length;

            char clickedCell = board[clickRow][clickColumn];
            if (clickedCell == 'M') {
                board[clickRow][clickColumn] = 'X';
            } else if (clickedCell == 'E') {
                int adjacentCellRows[] = {-1, -1, -1, 0, 0, 1, 1, 1};
                int adjacentCellCols[] = {-1, 0, 1, -1, 1, -1, 0, 1};
                int adjacentMineCount = 0;
                for (int i = 0; i < 8; i++) {
                    int neighbourRow = clickRow + adjacentCellRows[i];
                    int neighbourCol = clickColumn + adjacentCellCols[i];
                    if (isValid(neighbourRow, neighbourCol, rows, cols)) {
                        if (board[neighbourRow][neighbourCol] == 'M') {
                            adjacentMineCount += 1;
                        }
                    }
                }
                visited[clickRow][clickColumn] = true;
                if (adjacentMineCount > 0) {
                    board[clickRow][clickColumn] = (char) (adjacentMineCount + '0');
                } else {
                    for (int i = 0; i < 8; i++) {
                        int neighbourRow = clickRow + adjacentCellRows[i];
                        int neighbourCol = clickColumn + adjacentCellCols[i];
                        if (isValid(neighbourRow, neighbourCol, rows, cols)
                                && board[neighbourRow][neighbourCol] != 'M') {
                            updateBoardUtil(board, visited, neighbourRow, neighbourCol);
                        }
                    }
                    board[clickRow][clickColumn] = 'B';
                }
            }
        }
        return board;
    }

    private static boolean isValid(int adjacentCellRow, int adjacentCellCol, int rows, int cols) {
        if (adjacentCellRow >= 0 && adjacentCellRow < rows && adjacentCellCol >= 0 && adjacentCellCol < cols) {
            return true;
        }
        return false;
    }
}
