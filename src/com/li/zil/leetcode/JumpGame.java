package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/9/16.
 */
public class JumpGame {
	public boolean canJump(int[] A) {
		boolean[] valid = new boolean[A.length];
		valid[A.length - 1] = true;

		for (int i = 0; i < A.length - 1; i++) {
			valid[i] = A[i] != 0 ? true : false;
		}

		return helper(A, valid, 0);
	}

	public boolean helper(int[] A, boolean[] valid, int index) {
		if (valid[index] = false) {
			return false;
		}

		if (index == A.length - 1) {
			return true;
		}

		for (int i = 1; i <= A[index]; i++) {
			if (helper(A, valid, index + i)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * This solution's running time is O(n). For each index, it checks the furthest index it can reach
	 * and if one passes the end point, simply return true. If not, just store the furthest index so
	 * far and move on. If the index it's checking is beyond the furthest index it can reach, then
	 * return false;
	 */
	public boolean canJump2(int[] A) {
		int furthestIndex = 0;

		for (int i = 0; i < A.length && i <= furthestIndex; i++) {
			if (i + A[i] > furthestIndex) {
				furthestIndex = i + A[i];
			}
			if (furthestIndex >= A.length - 1) {
				return true;
			}
		}

		return false;
	}
}
