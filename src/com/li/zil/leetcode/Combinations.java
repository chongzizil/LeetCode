package com.li.zil.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zil on 2014/8/10.
 */
public class Combinations {
	public  List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> numList = new ArrayList<Integer>();
		int[] nums = new int[n];

		for(int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}

		next(res, numList, nums, n, k, 0, 0);

		return res;
	}

	public  void next(List<List<Integer>> res, List<Integer> numList, int[] nums, int n, int k, int index, int curr) {
		if (curr == k) {
			List<Integer> tmp = new ArrayList<Integer>(numList);
			res.add(tmp);
			return;
		}

		for (int i = index; i < n - (k - curr) + 1; i++) {
			numList.add(nums[i]);
			next(res, numList, nums, n, k, i + 1, curr + 1);
			numList.remove((Integer) nums[i]);
		}
	}

	// More concise
	public  List<List<Integer>> combine2(int n, int k) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		combine2(res, new ArrayList<Integer>(), n, k, 0, 0);
		return res;
	}

	public  void combine2(List<List<Integer>> res, List<Integer> numList, int n, int k, int index, int curr) {
		if (curr == k) {
			res.add(numList);
		} else {
			for (int i = index; i < n - (k - curr) + 1; i++) {
				List<Integer> tmpList = new ArrayList<Integer>(numList);
				tmpList.add(i + 1);
				combine2(res, tmpList, n, k, i + 1, curr + 1);
			}
		}
	}
}
