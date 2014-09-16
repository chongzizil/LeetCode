package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/7/27.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int numOfSquares = n / 2;
        int currSquare = 0;

        while (currSquare < numOfSquares) {
            int row = currSquare;
            /**
             * For each square, we swap A - > B -> C -> D -> A, once the square is done, move to the inner one.
             * To be noticed that if the inner one has only one element, then it is ignored since its place will
             * not be changed.
             *
             * A1 A2 A3 A4 A5 A6 B1
             * D6                B2
             * D5                B3
             * D4                B4
             * D3                B5
             * D2                B6
             * D1 C6 C5 C4 C3 C2 C1
             */
            for (int i = row; i < n - row - 1; i++) {
                int last = n - row - 1;
                int tmp = matrix[row][i];
                matrix[row][i] = matrix[n - i - 1][row];
                matrix[n - i - 1][row] = matrix[n - row - 1][n - i - 1];
                matrix[n - row -1][n - i - 1] = matrix[i][n - row - 1];
                matrix[i][n - row - 1] = tmp;
            }
            currSquare++;
        }
    }
}
