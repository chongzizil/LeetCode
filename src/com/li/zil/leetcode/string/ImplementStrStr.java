package com.li.zil.leetcode.string;

public class ImplementStrStr {
	public String strStr(String haystack, String needle) {
		if (haystack == null || needle == null) {
			return null;
		}

		for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
			int count = 0;
			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) != needle.charAt(j)) {
					break;
				}
				count++;
			}
			if (count == needle.length()) {
				return haystack.substring(i);
			}
		}

		return null;
	}
}
