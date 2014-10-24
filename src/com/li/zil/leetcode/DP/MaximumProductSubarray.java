package com.li.zil.leetcode.DP;

public class MaximumProductSubarray {
  public int maxProduct(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }

    int n = A.length;
    int[] lMin = new int[n];
    int[] lMax = new int[n];
    int res = Integer.MIN_VALUE;

    lMin[0] = A[0];
    lMax[0] = A[0];

    for (int i = 1; i < n; i++) {
      lMax[i] = Math.max(A[i] * lMax[i - 1], A[i] * lMin[i - 1]);
      lMax[i] = Math.max(lMax[i], A[i]);
      lMin[i] = Math.min(A[i] * lMax[i - 1], A[i] * lMin[i - 1]);
      lMin[i] = Math.min(lMin[i], A[i]);
    }

    for (int i = 0; i< n; i++) {
      res = Math.max(res, lMax[i]);
    }

    return res;
  }
}
