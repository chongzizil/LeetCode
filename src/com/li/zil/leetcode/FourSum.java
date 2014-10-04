package com.li.zil.leetcode;

import java.util.*;

/**
 * This solution is enlighten by code from https://oj.leetcode.com/discuss/3950/tle-on-4sum-using-hashtable
 */
public class FourSum {
	public List<List<Integer>> fourSum(int[] num, int target) {
		// Key stores two elements' sum and value stores that two elements. Use set to make sure no
		// duplicates.
		Map<Integer, Set<List<Integer>>> hashMap = new HashMap<Integer, Set<List<Integer>>>();
		Set<List<Integer>> hashSet = new HashSet<List<Integer>>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int n = num.length;

		// Sort first...
		Arrays.sort(num);

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int sum = num[i] + num[j];
				if (hashMap.get(target - sum) != null) {
					// If the pair of numbers exist in the map, whether one pair or multiple pairs, retrieve
					// them and added to the set.
					for (List<Integer> list : hashMap.get(target - sum)) {
						List<Integer> tmpList = new ArrayList<Integer>();
						tmpList.add(list.get(0));
						tmpList.add(list.get(1));
						tmpList.add(num[i]);
						tmpList.add(num[j]);
						hashSet.add(tmpList);
					}
				}
			}
			// In order to make sure the same number won't be use twice, only added the pairs which are
			// previous checked.
			for (int j = 0; j < i; j ++) {
				if (hashMap.get((Integer) (num[i] + num[j])) != null) {
					// Add the pair the set if for the sum of the two elements already exists
					List<Integer> tmpList = new ArrayList<Integer>();
					tmpList.add(num[j]);
					tmpList.add(num[i]);
					hashMap.get((Integer) (num[i] + num[j])).add(tmpList);
				} else {
					// Create a new set with the pair of the two numbers
					Set<List<Integer>> tmpSet = new HashSet<List<Integer>>();
					List<Integer> tmpList = new ArrayList<Integer>();
					tmpList.add(num[j]);
					tmpList.add(num[i]);
					tmpSet.add(tmpList);
					hashMap.put(num[i] + num[j], tmpSet);
				}
			}
		}

		for (List<Integer> list : hashSet) {
			res.add(list);
		}

		return res;
	}
}
