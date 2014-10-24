package com.li.zil.leetcode.DP;

/**
 * For more reference:
 * http://cs.lmu.edu/~ray/notes/binarytrees/
 * http://www.geeksforgeeks.org/program-nth-catalan-number/
 */
public class UniqueBinarySearchTrees {
	// Method 1 (DP)
	public int numTrees1(int n) {
		int[] number = new int[n + 1];
		number[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				number[i] += number[j]*number[i - j - 1];
			}
		}
		return number[n];
	}

	// Method 2 (This method has a significant problem! Direct calculate the factorial of a given n may
	// easily cause overflow...
	public int numTrees2(int n) {
		return (int) (factorial(2 * n) / (factorial(n + 1) * factorial(n)));
	}

	public long factorial(int n) {
		long factorialNum = 1;
		for (int i = 1; i <= n; i++) {
			factorialNum *= i;
		}
		return factorialNum;
	}
}
