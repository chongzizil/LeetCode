package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/8/9.
 */
public class LengthofLastWord {
	public int lengthOfLastWord(String s) {
		int count = 0;
		boolean newSpace = false;

		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				newSpace = true;
			} else {
				if (newSpace) {
					count = 0;
					newSpace = false;
				}
				count++;
			}
		}

		return count;
	}

	//
	public int lengthOfLastWord2(String s) {
		String[] words = s.split("\\s+");

		if (words.length > 0) {
			return words[words.length - 1].length();
		}

		return 0;
	}

	//
	public int lengthOfLastWord3(String s) {
		int count = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ' && count > 0) {
				return count;
			} else if (s.charAt(i) != ' ') {
				count++;
			}
		}

		return count;
	}
}
