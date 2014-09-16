package com.li.zil.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zil on 2014/7/27.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            Set<Character> checkSquareSet = new HashSet<Character>();
            Set<Character> checkRowSet = new HashSet<Character>();
            Set<Character> checkColSet = new HashSet<Character>();
            int initRow = (i / 3) * 3;
            int initCol = (i % 3) * 3;
            for(int j = 0; j < 9; j++) {
                int offsetRow = j / 3;
                int offsetCol = j % 3;
                if(!isValid(board, checkSquareSet, board[initRow + offsetRow][initCol + offsetCol])) {
                    return false;
                }
            }

            for(int j = 0; j < 9; j++) {
                if(!isValid(board, checkRowSet, board[i][j])) {
                    return false;
                }
            }

            for(int j = 0; j < 9; j++) {
                if(!isValid(board, checkColSet, board[j][i])) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isValid(char[][] board, Set<Character> set, char c) {
        if (c != '.' && !set.add(c)) {
            return false;
        }
        return true;
    }
}
