package com.li.zil;

/**
 * Created by Zil on 2014/9/18.
 */
public class BinarySearch {
	public static int binarySearch(int[] nums, int target) {
		int n = nums.length;
		int low = 0;
		int high = n - 1;

		while(low <= high) {
			int mid = low + (high - low)/2;
			if (nums[mid] == target) {
				return mid;
			}

			if (target < nums[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return -1;
	}
}
