package com.li.zil.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// This solution has O(n^2) time complexity...
// First sort the array, then take a num and for the rest of numbers behind it, use two pointers
// from front and end to find the required triple....
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (num.length < 3 || num == null) {
			return res;
		}

		Arrays.sort(num);

		for (int i = 0; i < num.length - 2; i++) {
			// Skip the duplicates
			if (i > 0 && num[i] == num[i - 1]) {
				continue;
			}
			int j = i + 1;
			int k = num.length - 1;
			while (j < k) {
				int sum = num[i] + num[j] + num[k];
				if (sum == 0) {
					List<Integer> tmpList = new ArrayList<Integer>();
					tmpList.add(num[i]);
					tmpList.add(num[j]);
					tmpList.add(num[k]);
					res.add(tmpList);
					j++;
					k--;
					// Skip the duplicates
					while (j < k && num[j] == num[j - 1]) {
						j++;
					}
					// Skip the duplicates
					while (j < k && num[k] == num[k + 1]) {
						k--;
					}
				} else if (sum < 0) {
					j++;
				} else {
					k--;
				}
			}
		}

		return res;
	}
}
