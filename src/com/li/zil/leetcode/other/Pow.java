package com.li.zil.leetcode.other;

// Divide and conquer.
public class Pow {
	public double pow(double x, int n) {
		boolean isPositive = true;

		if (n == 0) {
			return 1.0;
		}
		if (n == 1) {
			return x;
		}

		if (n < 0) {
			n = -n;
			isPositive = false;
		}

		int i = n / 2;
		int j = n - 2 * i;
		double l = pow(x, i);
		double r = pow(x, j);
		double res = l * l * r;

		return isPositive ? res : 1 / res;
	}
}
