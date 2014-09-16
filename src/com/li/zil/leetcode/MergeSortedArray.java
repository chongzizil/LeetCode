package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/7/24.
 */
public class MergeSortedArray {
	// A naive solution which need to create new arrays
	public void merge(int A[], int m, int B[], int n) {
		int indexA = 0;
		int indexB = 0;
		int[] l1 = new int[m + 1];
		int[] l2 = new int[n + 1];

		for (int i = 0; i < m; i++) {
			l1[i] = A[i];
		}

		for (int j = 0; j < n; j++) {
			l2[j] = B[j];
		}

		l1[m] = Integer.MAX_VALUE;
		l2[n] = Integer.MAX_VALUE;

		for (int i = 0; i < m + n; i++) {
			if (l1[indexA] < l2[indexB]) {
				A[i] = l1[indexA];
				indexA++;
			} else {
				A[i] = l2[indexB];
				indexB++;
			}
		}
	}

	// More advanced solution
	public void merge2(int A[], int m, int B[], int n) {
		int indexA = m - 1;
		int indexB = n - 1;

		for (int i = m + n - 1; i >= 0; i--) {
			if (indexB < 0) {
				return;
			} else if (indexA < 0) {
				A[i] = B[indexB];
				indexB--;
			} else if (A[indexA] > B[indexB]) {
				A[i] = A[indexA];
				indexA--;
			} else if (A[indexA] <= B[indexB]) {
				A[i] = B[indexB];
				indexB--;
			}
		}
	}
}
