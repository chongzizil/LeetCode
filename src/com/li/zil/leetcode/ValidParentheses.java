package com.li.zil.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
	public boolean isValid(String s) {
		Deque<Character> queue = new ArrayDeque<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(' || c == '[' || c == '{') {
				queue.addLast(c);
				continue;
			}

			if (queue.isEmpty()) {
				return false;
			}

			char left = queue.pollLast();

			if (!((left == '(' && c == ')')
					|| (left == '[' && c == ']')
					|| (left == '{' && c == '}'))) {
				return false;
			}
		}

		return queue.isEmpty();
	}
}
