package com.li.zil.leetcode.string;

public class validPalindrome {
	public boolean isPalindrome(String s) {
		int l = 0;
		int r = s.length();

		s = s.toLowerCase();

		while (l < r) {
			if (s.charAt(l) == s.charAt(r)) {
				l++;
				r--;
			} else {
				return false;
			}
		}

		return true;
	}
}
