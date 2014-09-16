package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/8/10.
 */
public class PalindromeNumber {
	// Be aware of negative number, overflow in this case is not important, because if the original
	// number is not overflowed and it is a palindrome, them its reverse number will not be overflowed.
	public boolean isPalindrome(int x) {
		int origin = x;
		int reverse = 0;

		if (x < 0) { return false; }

		while (x != 0) {
			reverse = reverse * 10 + x % 10;
			x /= 10;
		}

		return origin == reverse;
	}
}
