package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/8/7.
 */
public class SetMatrixZeroes {

	// First check if there are any zeros in first row and column. Then traverse all the element
	// except in first row and column, if element in row x col y is 0, stores 0 in matrix[x][0] and
	// matrix[0][y], since those two elements will be zeroes eventually, therefore there's no worry
	// about losing the original element. Last check the first row and first column.
	public void setZeroes(int[][] matrix) {
		boolean zeroInFirstRow = false;
		boolean zeroInFirstCol = false;

		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {

				if (matrix[i][j] == 0) {
					if (!zeroInFirstRow && i == 0) { zeroInFirstRow = true; }
					if (!zeroInFirstCol && j == 0) { zeroInFirstCol = true; }
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for(int i = 1; i < matrix.length; i++) {
			for(int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (zeroInFirstRow) {
			for(int col = 0; col < matrix[0].length; col++) {
				matrix[0][col] = 0;
			}
		}

		if (zeroInFirstRow) {
			for(int row = 0; row < matrix.length; row++) {
				matrix[row][0] = 0;
			}
		}
	}

	// Not accepte
	public void setZeroes2(int[][] matrix) {
		long bitmapOfRow = 0;
		long bitmapOfCol = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					bitmapOfRow |= 1L << i;
					bitmapOfCol |= 1L << j;
				}
			}
		}

		for(int row = 0; row < matrix.length; row++) {
			if (((bitmapOfRow >> row) & 1) == 1) {
				for(int col = 0; col < matrix[0].length; col++) {
					matrix[row][col] = 0;
				}
			}
		}

		for(int col = 0; col < matrix[0].length; col++) {
			if (((bitmapOfCol >> col) & 1) == 1) {
				for(int row = 0; row < matrix.length; row++) {
					matrix[row][col] = 0;
				}
			}
		}
	}
}
