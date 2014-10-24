package com.li.zil.leetcode.DP;

public class UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
			return 0;
		}

		int row = obstacleGrid.length;
		int col = obstacleGrid[0].length;
		int[][] paths = new int[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (obstacleGrid[i][j] == 1) {
					// If there's an obstacle, then assume there's 0
					// path to that cell
					paths[i][j] = 0;
				} else if (i == 0 && j == 0) {
					// Base case
					paths[i][j] = 1;
				} else if (i == 0 && j > 0) {
					// Base case
					paths[i][j] = paths[i][j - 1];
				} else if (j == 0 && i > 0) {
					// Base case
					paths[i][j] = paths[i - 1][j];
				} else {
					paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
				}
			}
		}

		return paths[row - 1][col - 1];
	}
}
