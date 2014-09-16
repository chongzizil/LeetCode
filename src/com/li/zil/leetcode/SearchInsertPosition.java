package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/7/15.
 */
public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		int low = 0;
		int high = A.length - 1;
		int mid = 0;
		boolean isLarger = false;

		if (A.length == 0) {
			return 0;
		}

		while (low <= high) {
			mid = (low + high) / 2;
			if (target == A[mid]) {
				return mid;
			} else if (target < A[mid]) {
				high = mid - 1;
				isLarger = false;
			} else if (target > A[mid]) {
				low = mid + 1;
				isLarger = true;
			}
		}

		return isLarger ? mid + 1 : mid;
	}
}
