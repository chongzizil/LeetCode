package com.li.zil.leetcode.BinarySearch;

// http://leetcode.com/2010/04/searching-element-in-rotated-array.html
public class SearchingRotatedSortedArray {
	public int search(int[] A, int target) {
		int l = 0;
		int r = A.length - 1;

		while (l <= r) {
			int m = l + (r - l) / 2;

			if (A[m] == target) {
				return m;
			}

      // Left half is sorted...
			if (A[l] <= A[m]) {
				if (A[l] <= target && A[m] > target) {
					r = m - 1;
				} else {
					l = m + 1;
				}
			}
      // Right half is sorted...
      else {
				if (A[m] < target && target <= A[r]) {
					l = m + 1;
				} else {
					r = m - 1;
				}
			}
		}

		return -1;
	}
}
