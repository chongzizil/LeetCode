package com.li.zil.leetcode.DP;

import java.util.Set;

public class wordBreak {
  public boolean wordBreak(String s, Set<String> dict) {
    if (s == null || s.length() == 0) {
      return false;
    }

    int n = s.length();
    boolean[][] res = new boolean[n][n];

    for (int l = 0; l < n; l++) {
      for (int i = 0; i < n - l; i++) {
        int j = i + l;
        if (i == j && dict.contains(s.charAt(i))) {
          res[i][j] = true;
        } else if (dict.contains(s.substring(i, j + 1))) {
          res[i][j] = true;
        } else {
          res[i][j] = false;
          for (int k = i; k < j; k++) {
            res[i][j] = res[i][j] || (res[i][k] && res[k + 1][j]);
          }
        }
      }
    }

    return res[0][n - 1];
  }
}
