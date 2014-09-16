package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/7/23.
 */
public class SortColors {
	/**
	 * Two pass solution
	 * @param A The array to be sorted.
	 */
	public void sortColors1(int[] A) {
		int numOfZero = 0;
		int numOfOne = 0;
		int numOfTwo = 0;
		for (int i = 0; i < A.length; i++) {
			switch(A[i]) {
				case 0: numOfZero++; break;
				case 1: numOfOne++; break;
				case 2: numOfTwo++; break;
				default: throw new IllegalArgumentException();
			}
		}

		for (int i = 0; i < A.length; i++) {
			if (numOfZero > 0) {
				A[i] = 0;
				numOfZero--;
			} else if (numOfOne > 0) {
				A[i] = 1;
				numOfOne--;
			} else {
				A[i] = 2;
			}
		}
	}

	/**
	 * One pass solution.
	 * @param A The array to be sorted.
	 */
	public void sortColors2(int[] A) {
		int lastIndexOfZero = -1;
		int firstIndexOfTwo = A.length;
		int index = 0;
		if (A.length < 2) { return; }
		for(int i = 0; i < A.length; i++) {
			if (A[index] == 0) {
				if (index != lastIndexOfZero + 1) {
					int tmp = A[lastIndexOfZero + 1];
					A[lastIndexOfZero + 1] = 0;
					A[index] = tmp;
				}
				lastIndexOfZero++;
				index++;
			} else if (A[index] == 1) {
				index++;
			} else {
				int tmp = A[firstIndexOfTwo - 1];
				A[firstIndexOfTwo - 1] = 2;
				A[index] = tmp;
				firstIndexOfTwo--;
			}
		}
	}
}
