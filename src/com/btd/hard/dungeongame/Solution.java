package com.btd.hard.dungeongame;

/**
 * Leet Code - Hard - Problem 174 - Dungeon game
 * The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of m x n rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through dungeon to rescue the princess.
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 * Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms; other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).
 * To reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 * Return the knight's minimum initial health so that he can rescue the princess.
 * <p>
 * Note that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 * Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
 * Output: 7
 * Explanation: The initial health of the knight must be at least 7 if he follows the optimal path: RIGHT-> RIGHT -> DOWN -> DOWN.
 * https://leetcode.com/problems/dungeon-game/
 * <p>
 * Solution: https://www.geeksforgeeks.org/minimum-positive-points-to-reach-destination/
 */
public class Solution {

    public static int calculateMinimumHP(int[][] dungeon) {
        int r = dungeon.length;
        int c = dungeon[0].length;

        // health[i][j] = health required to enter this cell i,j to continue rest of journey.
        int[][] health = new int[r][c];

        health[r - 1][c - 1] = dungeon[r - 1][c - 1] <= 0 ? 1 - dungeon[r - 1][c - 1] : 1;
        for (int i = r - 2; i >= 0; i--) {
            health[i][c - 1] = Math.max(health[i + 1][c - 1] - dungeon[i][c - 1], 1);
        }
        for (int j = c - 2; j >= 0; j--) {
            health[r - 1][j] = Math.max(health[r - 1][j + 1] - dungeon[r - 1][j], 1);
        }
        for (int i = r - 2; i >= 0; i--) {
            for (int j = c - 2; j >= 0; j--) {
                int pointsToExit = Math.min(health[i + 1][j], health[i][j + 1]);
                health[i][j] = Math.max(pointsToExit - dungeon[i][j], 1);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(health[i][j]+" ");
            }
            System.out.println();
        }
        return health[0][0];
    }

    public static void main(String args[]) {
        int points[][] = {{-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}};
        calculateMinimumHP(points);
    }

}
