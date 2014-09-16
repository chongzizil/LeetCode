package com.li.zil.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zil on 2014/7/24.
 */
public class NQUEENS {
	////////////////////////////////////////////// Iterative solution /////////////////////////////////////
	public List<String[]> solveNQueens(int n) {
		List<int[]> solutions = new ArrayList<int[]>();
		List<String[]> res = new ArrayList<String[]>();
		int indexOfRow = 0;
		int indexOfCol = 0;
		// The index of the array indicates the row and each value
		// of the array indeicates each colume.
		int[] board = new int[n];
		Arrays.fill(board, Integer.MIN_VALUE);

		while(indexOfRow < n) {
			while(indexOfCol < n) {
				// If the place is valid, try to place a queen on it.
				// Otherwise try the next colume.
				if(isValid(board, n, indexOfRow, indexOfCol)) {
					board[indexOfRow] = indexOfCol;
					indexOfCol = 0;
					break;
				} else {
					indexOfCol++;
				}
			}
			// If no place of the row is available, check if it's the first row, if so, then all solutions
			// should be computed. Otherwise try the previous row and start on the next colume of the queen of
			// that row.
			if (board[indexOfRow] == Integer.MIN_VALUE) {
				if (indexOfRow == 0) {
					break;
				} else {
					indexOfRow--;
					indexOfCol = board[indexOfRow] + 1;
					board[indexOfRow] = Integer.MIN_VALUE;
					continue;
				}
			}
			// If it's the last row which means all queens are placed properly, consider it a solution and
			// add it to the list.
			if (indexOfRow == n - 1) {
				solutions.add(board.clone());
				indexOfCol = board[indexOfRow] + 1;
				board[indexOfRow] = Integer.MIN_VALUE;
				continue;
			}
			indexOfRow++;
		}

		// Convert the solutions to the required format.
		for(int[] solution : solutions) {
			String[] solutionStr = new String[n];
			for(int i = 0; i < solution.length; i++) {
				String before = "";
				String after = "";
				for (int j = 0; j < solution[i]; j++) {
					before += ".";
				}
				for (int j = solution[i] + 1; j < n; j++) {
					after += ".";
				}
				solutionStr[i] = before + "Q" + after;
			}
			res.add(solutionStr);
		}

		return res;
	}

	/**
	 * Check if it is valid to place a queen in a specific position of a existing board
	 * @param board the board where the queen will be placed on.
	 * @param n the size of the board.
	 * @param row the row of the board where will be check
	 * @param col the colume of the board where will be check
	 * @return true if it's valid, otherwise return false;
	 */
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


	////////////////////////////////////////////// Recursive solution /////////////////////////////////////
	public List<String[]> solveNQueens2(int n) {
		List<int[]> solutions = new ArrayList<int[]>();
		List<String[]> res = new ArrayList<String[]>();
		// The index of the array indicates the row and each value
		// of the array indeicates each colume.
		int[] board = new int[n];
		Arrays.fill(board, Integer.MIN_VALUE);

		place(solutions, board, n, 0);

		for(int[] solution : solutions) {
			String[] solutionStr = new String[n];
			for(int i = 0; i < solution.length; i++) {
				String before = "";
				String after = "";
				for (int j = 0; j < solution[i]; j++) {
					before += ".";
				}
				for (int j = solution[i] + 1; j < n; j++) {
					after += ".";
				}
				solutionStr[i] = before + "Q" + after;
			}
			res.add(solutionStr);
		}

		return res;
	}

	public void place(List<int[]> solutions, int[] board, int n, int row) {
		// If the last row is finished, then a solution is computed.
		// Otherwise check if there's available place for the queen, if it has then check the next row, if it
		// hasn't then go back.
		if (row == n) {
			solutions.add(board);
		} else {
			for (int i = 0; i < n; i++) {
				if(isValid(board, n, row, i)) {
					board[row] = i;
					place(solutions, board.clone(), n, row + 1);
				}
			}
		}
	}

	public boolean isValid2(int[] board, int n, int row, int col) {

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
