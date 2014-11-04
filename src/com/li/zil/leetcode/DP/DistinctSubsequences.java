package com.li.zil.leetcode.DP;

public class DistinctSubsequences {
  public int numDistinct(String S, String T) {
    int[][] dp = new int[S.length() + 1][T.length() + 1];
    int ns = S.length();
    int nt = T.length();

    if (ns < nt) {
      return 0;
    }

    for (int i = 0; i <= ns; i++) {
      dp[i][0] = 1;
    }

    for (int i = 1; i <= ns; i++) {
      for (int j = 1; j <= nt; j++) {
        dp[i][j] = dp[i - 1][j];
        if (S.charAt(i - 1) == T.charAt(j - 1)) {
          dp[i][j] += dp[i - 1][j - 1];
        }
      }
    }

    return dp[ns][nt];
  }
}
