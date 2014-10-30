package com.li.zil.leetcode;

public class SingleNumberII {
	public int singleNumber(int[] A) {
		int[] count = new int[32];
		int result = 0;
		for(int i = 0; i < 32; i++) {
			for(int j = 0; j < A.length; j++) {
				if (((A[j] >> i) & 1) == 1) {
					count[i]++;
				}
			}
			result |= (count[i] % 3) << i;
		}

		return result;
	}

	// https://oj.leetcode.com/discuss/6632/challenge-me-thx
	// Another neat solution, and much more easy to understand...
	// It use two bit to store the number of times of 1 appears in
	// the array. (ones, twos: 00 -> 10 -> 01 -> 00)
	public int singleNumberB(int[] A) {
		int ones = 0, twos = 0;
		for(int i = 0; i < A.length; i++){
			ones = (ones ^ A[i]) & ~twos;
			twos = (twos ^ A[i]) & ~ones;
		}
		return ones;
	}

	//TODO: One very neat solution, still need time to figure it out.
//	public int singleNumber(int[] A) {
//		int ones = 0, twos = 0, threes = 0;
//		for (int i = 0; i < A.length; i++) {
//			twos |= A[i] & ones;
//			ones ^= A[i];
//			threes = ones & twos;
//			ones &= ~threes;
//			twos &= ~threes;
//		}
//		return ones;
//	}
}
