package com.li.zil.leetcode;

/**
 * If two numbers are equal, then the xor of the two numbers results in all zeros. Therefore xor of the
 * extra unique number and all zeros will results in the unique number itself.
 */
public class SingleNumber {
	public int singleNumber(int[] A) {
		int number = A[0];
		for (int i = 1; i < A.length; i++) {
			number = number ^ A[i];
		}
		return number;
	}
}
