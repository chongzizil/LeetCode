package com.li.zil.leetcode.DP;

public class DecodeWays {
	public int numDecodings(String s) {
		int n = s.length();
		int[] res = new int[n + 1];

		if (s == null || s.length() == 0) {
			return 0;
		}

		res[0] = 1;
		res[1] = s.charAt(0) == '0' ? 0 : 1;

		for (int i = 2; i <= n; i++) {
			if (s.charAt(i - 1) != '0') {
				res[i] += res[i - 1];
			}

			int doubleDigitNum = 10 * (s.charAt(i - 2) - '0') + s.charAt(i - 1) - '0';
			if (doubleDigitNum <= 26 && doubleDigitNum >= 10) {
				res[i] += res[i - 2];
			}
		}

		return res[n];
	}
}
