package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/7/23.
 */
public class RemoveElement {
	public int removeElementA(int[] A, int elem) {
		int originalLength = A.length;
		int removedLength = 0;
		int lastIndex = 0;

		if (A.length == 0) {
			return 0;
		}

		sort(A, 0, A.length - 1);

		for (int i = 0; i < A.length; i++) {
			if (A[i] == elem) {
				removedLength++;
				lastIndex = i;
			}
		}

		if (removedLength > 0) {
			for (int i = lastIndex + 1; i < A.length; i++) {
				A[i - removedLength] = A[i];
			}
		}

		return originalLength - removedLength;
	}

	public void sort(int[] A, int p, int q) {
		if (p < q) {
			sort(A, p, (q + p) / 2);
			sort(A, (q + p) / 2 + 1, q);
		}
		sortHelper(A, p, q);
	}

	public void sortHelper(int[] A, int p, int q) {
		if (p == q) {
			return;
		}
		int r = (q + p) / 2;
		int[] a = new int[r - p + 2];
		int[] b = new int[q - r + 1];
		int indexA = 0;
		int indexB = 0;
		for (int i = 0; i < r - p + 1; i++) {
			a[i] = A[p + i];
		}
		for (int i = 0; i < q - r; i++) {
			b[i] = A[r + i + 1];
		}
		a[r - p + 1] = Integer.MAX_VALUE;
		b[q - r] = Integer.MAX_VALUE;
		for (int i = 0; i < q - p + 1; i++) {
			if(a[indexA] <= b[indexB]) {
				A[p + i] = a[indexA];
				indexA++;
			} else {
				A[p + i] = b[indexB];
				indexB++;
			}
		}
	}

	///////////////////////// B ////////////////////
	public int removeElementB(int[] A, int elem) {
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == elem) {
				count++;
			} else if (count > 0) {
				A[i - count] = A[i];
			}
		}
		return A.length - count;
	}
}