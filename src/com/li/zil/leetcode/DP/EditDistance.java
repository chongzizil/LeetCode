package com.li.zil.leetcode.DP;

public class EditDistance {


  // This is someone else bottom-top solution, I guess the latter one is more intuitive to me...
  public int minDistanceA(String word1, String word2) {
    int n = word1.length();
    int m = word2.length();

    int[][] dp = new int[n + 1][m + 1];
    for (int i = 0; i < m + 1; i++) {
      dp[0][i] = i;
    }
    for (int i = 0; i < n + 1; i++) {
      dp[i][0] = i;
    }


    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
        }
      }
    }
    return dp[n][m];
  }

  // This is a top-bottom solution
  String word1;
  String word2;
  int[][] c;

  public int minDistanceB(String word1, String word2) {
    if (word1 == null || word2 == null || (word1.length() == 0 && word2.length() == 0)) {
      return 0;
    }

    this.word1 = word1;
    this.word2 = word2;
    int n1 = word1.length();
    int n2 = word2.length();
    int res;

    c = new int[n1][n2];
    for (int i = 0; i < n1; i++) {
      for (int j = 0; j < n2; j++) {
        c[i][j] = Integer.MAX_VALUE;
      }
    }

    return minD(n1 - 1, n2 - 1);
  }

  private int minD(int i1, int i2) {
    if (i1 < 0 && i2 < 0) {
      return 0;
    } else if (i1 < 0 && i2 >= 0) {
      // Delete...
      return i2 + 1;
    } else if (i1 >= 0 && i2 < 0) {
      // Insert...
      return i1 + 1;
    }

    if (c[i1][i2] != Integer.MAX_VALUE) {
      return c[i1][i2];
    }

    if (word1.charAt(i1) == word2.charAt(i2)) {
      // Same
      c[i1][i2] = minD(i1 - 1, i2 - 1);
    } else {
      // Replace
      c[i1][i2] = Math.min(c[i1][i2], minD(i1 - 1, i2 - 1) + 1);
      // Insert
      c[i1][i2] = Math.min(c[i1][i2], minD(i1 - 1, i2) + 1);
      // Delete
      c[i1][i2] = Math.min(c[i1][i2], minD(i1, i2 - 1) + 1);
    }

    return c[i1][i2];
  }
}
