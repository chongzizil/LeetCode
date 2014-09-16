package com.li.zil.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zil on 2014/8/10.
 */
public class ReverseWordsinaString {
	public String reverseWords(String s) {
		List<String> words = new ArrayList<String>();
		String res = "";
		String word = "";

		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				if (word.length() > 0) {
					words.add(word);
					word = "";
				}
			} else {
				word += s.charAt(i);

				if (i == s.length() - 1 && word.length() > 0) {
					words.add(word);
					word = "";
				}
			}
		}

		for(int i = words.size() - 1; i >= 0; i--) {
			res += words.get(i);
			if (i != 0) {
				res += " ";
			}
		}

		return res;
	}

	// Optimized by using stringBuilder
	public String reverseWords1(String s) {
		List<String> words = new ArrayList<String>();
		StringBuilder res = new StringBuilder();
		StringBuilder word = new StringBuilder();

		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				if (word.length() > 0) {
					words.add(word.toString());
					word = new StringBuilder();
				}
			} else {
				word.append(s.charAt(i));

				if (i == s.length() - 1 && word.length() > 0) {
					words.add(word.toString());
					word = new StringBuilder();
				}
			}
		}

		for(int i = words.size() - 1; i >= 0; i--) {
			res.append(words.get(i));
			if (i != 0) {
				res.append(" ");
			}
		}

		return res.toString();
	}
}
