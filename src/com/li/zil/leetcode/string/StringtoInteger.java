package com.li.zil.leetcode.string;

// https://oj.leetcode.com/problems/string-to-integer-atoi/
public class StringtoInteger {
	// This is a O(n) solution without using String.trim..... (I guess I forget that function...)
	public static int atoi_A(String str) {
		boolean hasSign = false;
		int sign = 1;
		boolean hasNum = false;
		int digits = 0;
		int res = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ((c == '+' || c == '-') && !hasSign) {
				sign = c == '+' ? 1 : -1;
				hasSign = true;
			} else if (c >= '0' && c <= '9') {
				int num = c - '0';
				digits++;
				// Check overflow
				if (sign == 1) {
					// If the current result if larger than max/10 or equal to max/10 where the next number (lower digit)
					// is larger than the lower digit of max. It'll overflow...
					if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
						return Integer.MAX_VALUE;
					}
				} else {
					if (-res < Integer.MIN_VALUE / 10 || (-res == Integer.MIN_VALUE / 10 && -num < -Integer.MIN_VALUE % 10)) {
						return Integer.MIN_VALUE;
					}
				}
				res = res * 10 + num;
				hasNum = true;
			} else if (hasNum) {
				// If we've got a number and the next char is not a number... Then we just return
				return sign * res;
			} else if (hasSign || (!hasNum && c != ' ')) {
				// If we've already have the sign or encounter a char which is not a number nor a space and
				// we do not have a number, then the string is illegal and return 0...
				return 0;
			}
		}

		return sign * res;
	}

	// The optimized solution base on the one above, simply use long to store the number first.
	// It will simplify some logic.
	public static int atoi_AA(String str) {
		boolean hasSign = false;
		int sign = 1;
		boolean hasNum = false;
		long res = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ((c == '+' || c == '-') && !hasSign) {
				sign = c == '+' ? 1 : -1;
				hasSign = true;
			} else if (c >= '0' && c <= '9') {
				int num = c - '0';
				res = res * 10 + num;
				hasNum = true;
				// Check overflow
				if (sign == 1) {
					// If the current result if larger than max/10 or equal to max/10 where the next number (lower digit)
					// is larger than the lower digit of max. It'll overflow...
					if (res > Integer.MAX_VALUE) {
						return Integer.MAX_VALUE;
					}
				} else {
					if (-res < Integer.MIN_VALUE) {
						return Integer.MIN_VALUE;
					}
				}

			} else if (hasNum) {
				// If we've got a number and the next char is not a number... Then we just return
				return (int) (sign * res);
			} else if (hasSign || (!hasNum && c != ' ')) {
				// If we've already have the sign or encounter a char which is not a number nor a space and
				// we do not have a number, then the string is illegal and return 0...
				return 0;
			}
		}

		return (int) (sign * res);
	}

	// Not mine, with String.trim(), the logic is more clear...
	public int atoi_B(String str) {
		if(str == null) {
			return 0;
		}

		// Trim all spaces of the front and back.
		str = str.trim();
		if (str.length() == 0) {
			return 0;
		}

		int sign = 1;
		int index = 0;

		if (str.charAt(index) == '+') {
			index++;
		} else if (str.charAt(index) == '-') {
			sign = -1;
			index++;
		}

		// Long do make things easier..........
		long num = 0;
		for (; index < str.length(); index++) {
			if (str.charAt(index) < '0' || str.charAt(index) > '9')
				break;
			num = num * 10 + (str.charAt(index) - '0');
			if (num > Integer.MAX_VALUE && sign == 1) {
				break;
			}
		}
		if (num * sign > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		if (num * sign < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return (int)num * sign;
	}
}
