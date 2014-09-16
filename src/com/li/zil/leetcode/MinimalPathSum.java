package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/7/29.
 */
public class MinimalPathSum {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] path = new int[row][col];

        path[0][0] = grid[0][0];

        for(int i = 1; i < row; i++) {
            path[i][0] = path[i - 1][0] + grid[i][0];
        }

        for(int i = 1; i < col; i++) {
            path[0][i] += path[0][i - 1] + grid[0][i];;
        }

        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                path[i][j] = Math.min(path[i - 1][j], path[i][j - 1]) + grid[i][j];
            }
        }

        return path[row - 1][col - 1];
    }

    // A solution using only O(n) space
    public int minPathSum2(int[][] grid) {
        int row = grid[0].length;
        int col = grid.length;
        int[] path = new int[row];

        path[0] = grid[0][0];

        for(int i = 1; i < row; i++) {
            path[i] = path[i - 1] + grid[0][i];
        }

        for(int i = 1; i < col; i++) {
            for(int j = 0; j < row; j++) {
                if (j == 0) {
                    path[j] += grid[i][0];
                } else {
                    path[j] = Math.min(path[j - 1], path[j]) + grid[i][j];
                }
            }
        }

        return path[row - 1];
    }
}
