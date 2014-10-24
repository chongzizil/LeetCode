package com.li.zil.leetcode;

public class ClimbingStairs {
	public int climbStairsA(int n) {
		int[] res = new int[n];

		if (n < 2) {
			return n;
		}

		res[0] = 1;
		res[1] = 2;

		for (int i = 2; i < n; i++) {
			res[i] = res[i - 1] + res[i - 2];
		}

		return res[n - 1];
	}

	// Since each time calculating res[i] we only need the res[i-1] and
	// res[i-2], therefore below it's an optimized version which only
	// use constant space.
	public int climbStairsB(int n) {
		if (n < 2) {
			return n;
		}

		int prev = 2, prevPrev = 1;
		int now = 0;
		for (int i = 2; i < n; i++) {
			now = prev + prevPrev;
			prevPrev = prev;
			prev = now;
		}
		return now;
	}
}
