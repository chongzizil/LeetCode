package com.li.zil.leetcode.DP;


public class MaxSubArray {
	public int maxSubArrayA(int[] A) {
		int n = A.length;
		int[] l = new int[n];
		l[0] = A[0];
		int res = l[0];

		for (int i = 1; i < n; i++) {
			l[i] = Math.max(l[i - 1] + A[i], A[i]);
			res = Math.max(res, l[i]);
		}

		return res;
	}


}
