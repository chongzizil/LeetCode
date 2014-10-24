package com.li.zil.leetcode.DP;

import java.util.List;

public class Triangle {
  // Yet another DP solution which only use O(n) space.
  // Since for each node_i,j, we need the minimum path of node_i-1,j and node_i-1,j-1 (Or one of them)
  // We can reuse previous variables :) It's similar to 0-1 backpack problem
  public int minimumTotalA(List<List<Integer>> triangle) {
    int n = triangle.size();
    int res = Integer.MAX_VALUE;
    // minPath: i denotes row number, j denotes position
    int[] minPath = new int[n];

    minPath[0] = triangle.get(0).get(0);

    for (int i = 1; i < n; i++) {
      for (int j = triangle.get(i).size() - 1; j >= 0; j--) {
        int tmp = Integer.MAX_VALUE;

        if (j < triangle.get(i - 1).size()) {
          tmp = minPath[j];
        }

        if (j - 1 >= 0 && tmp > minPath[j - 1]) {
          tmp = minPath[j - 1];
        }

        minPath[j] = tmp + triangle.get(i).get(j);
      }
    }

    for (int i = 0; i < triangle.size(); i++) {
      res = Math.min(res, minPath[i]);
    }

    return res;
  }

  // DP solution... Space complexity is O(N^2), Time complexity should be O(nlogn)...
  public int minimumTotalB(List<List<Integer>> triangle) {
    int n = triangle.size();
    int res = Integer.MAX_VALUE;
    // minPath: i denotes row number, j denotes position
    int[][] minPath = new int[n][n];

    minPath[0][0] = triangle.get(0).get(0);

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < triangle.get(i).size(); j++) {
        minPath[i][j] = Integer.MAX_VALUE;

        if (j < triangle.get(i - 1).size()) {
          minPath[i][j] = minPath[i - 1][j];
        }

        if (j - 1 >= 0 && minPath[i][j] > minPath[i - 1][j - 1]) {
          minPath[i][j] = minPath[i - 1][j - 1];
        }

        minPath[i][j] += triangle.get(i).get(j);
      }
    }

    for (int i = 0; i < triangle.size(); i++) {
      res = Math.min(res, minPath[n - 1][i]);
    }

    return res;
  }

  //////////
  // TLE...
  List<List<Integer>> triangle;
  int n;

  public int minimumTotalX(List<List<Integer>> triangle) {
    this.triangle = triangle;
    n = triangle.size();

    return Math.min(helper(1, 0), helper(1, 1)) + triangle.get(0).get(0);
  }

  private int helper(int row, int pos) {
    if (row > n - 1 || pos > triangle.get(row).size() - 1) {
      return Integer.MAX_VALUE;
    }

    return Math.min(helper(row + 1, pos), helper(row + 1, pos + 1)) + triangle.get(row).get(pos);
  }
}
