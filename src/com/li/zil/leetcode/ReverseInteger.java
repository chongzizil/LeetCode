package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/7/14.
 */
public class ReverseInteger {
	public int reverse(int x) {
		int number = 0;
		boolean isPositive = true;
		if (x < 0) {
			isPositive = false;
			x *= -1;
		}

		while (x != 0) {
			number = x % 10 + number * 10;
			x = x / 10;
		}

		if (!isPositive) {
			number *= -1;
		}

		return number;
	}
}
