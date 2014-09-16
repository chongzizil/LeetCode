package com.li.zil.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zil on 2014/7/24.
 */
public class NQueensII {
	public int totalNQueens(int n) {
		// The index of the array indicates the row and each value
		// of the array indeicates each colume.
		int[] board = new int[n];
		List<Integer> res = new ArrayList<Integer>();
		Arrays.fill(board, Integer.MIN_VALUE);

		place(res, board, n, 0);

		return res.size();
	}

	public void place(List<Integer> res, int[] board, int n, int row) {
		// If the last row is finished, then a solution is computed.
		// Otherwise check if there's available place for the queen, if it has then check the next row, if it
		// hasn't then go back.
		if (row == n) {
			res.add(1);
		} else {
			for (int i = 0; i < n; i++) {
				if(isValid(board, n, row, i)) {
					board[row] = i;
					place(res, board.clone(), n, row + 1);
				}
			}
		}
	}

	public boolean isValid(int[] board, int n, int row, int col) {

		for (int i = 0; i < row; i++) {
			// Check if there exists a queen in the same colume.
			// To be noticed that there's no need to check if there
			// exists a queen in the same row.
			if (i != row && board[i] == col) {
				return false;
			}
			// Check if there exists a queen in the diagonal place.
			if (i != row && Math.abs(board[i] - col) == Math.abs(i - row)) {
				return false;
			}
		}

		return true;
	}
}
