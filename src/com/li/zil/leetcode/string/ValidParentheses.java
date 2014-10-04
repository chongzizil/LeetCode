package com.li.zil.leetcode.string;

import java.util.ArrayDeque;
import java.util.Deque;

// Simply use stack
public class ValidParentheses {
	public boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
				continue;
			}

			if (stack.isEmpty()) {
				return false;
			}

			char left = stack.poll();

			if (!((left == '(' && c == ')')
					|| (left == '[' && c == ']')
					|| (left == '{' && c == '}'))) {
				return false;
			}
		}

		return stack.isEmpty();
	}
}
