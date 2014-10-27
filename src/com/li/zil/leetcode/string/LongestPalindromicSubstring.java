package com.li.zil.leetcode.string;

public class LongestPalindromicSubstring {

  // More info: http://leetcode.com/2011/11/longest-palindromic-substring-part-i.html

  // This is an DP solution whose running time is O(n^2) and
  // require O(n^2) space...
  public String longestPalindrome(String s) {
    int n = s.length();

    int start = 0;
    int end = 0;
    int max = 0;
    boolean[][] dp = new boolean[n][n];

    for (int l = 0; l < n; l++) {
      for (int i = 0; i < n - l; i++) {
        int j = i + l;
        if (i == j) {
          dp[i][j] = true;
        } else {
          if (s.charAt(i) == s.charAt(j)) {
            if (l == 1) {
              dp[i][j] = true;
            } else if (dp[i + 1][j - 1]) {
              dp[i][j] = true;
            } else {
              dp[i][j] = false;
            }
          } else {
            dp[i][j] = false;
          }
        }
      }
    }

    for (int l = 0; l < n; l++) {
      for (int i = 0; i < n - l; i++) {
        int j = i + l;
        if (dp[i][j] && j - i > max) {
          start = i;
          end = j;
        }
      }
    }

    return s.substring(start, end + 1);
  }
}
