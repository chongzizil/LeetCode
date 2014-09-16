package com.li.zil.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (num.length < 3) {
			return res;
		}

		Arrays.sort(num);

		for (int a = 0; a < num.length - 2; a++) {
			if (a > 0 && num[a] == num [a - 1]) {
				continue;
			}
			int b = a + 1;
			int c = num.length - 1;
			while (b < c) {
				int sum = num[a] + num[b] + num[c];
				if (sum == 0) {
					List<Integer> tmp = new ArrayList<Integer>();
					tmp.add(num[a]);
					tmp.add(num[b]);
					tmp.add(num[c]);
					res.add(tmp);
					b++;
					while (b < c && num[b] == num[b - 1]) {
						b++;
					}
					c--;
					while (b < c && num[c] == num[c + 1]) {
						c--;
					}
				} else if (sum < 0) {
					b++;
					while (b < c && num[b] == num[b - 1]) {
						b++;
					}
				} else {
					c--;
					while (b < c && num[c] == num[c + 1]) {
						c--;
					}
				}
			}
		}

		return res;
	}
}
