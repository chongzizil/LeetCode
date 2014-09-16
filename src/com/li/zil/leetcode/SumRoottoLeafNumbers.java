package com.li.zil.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Zil on 2014/8/10.
 */
public class SumRoottoLeafNumbers {
	public int sumNumbers(TreeNode root) {
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		Set<TreeNode> found = new HashSet<TreeNode>();
		int sum = 0;
		int currSum = 0;

		if (root == null) { return sum; }

		stack.push(root);

		while(!stack.isEmpty()) {
			TreeNode node = stack.peek();
			currSum = currSum * 10 + node.val;

			if (node.left == null && node.right == null) {
				found.add(node);
				stack.pop();
				sum += currSum;
				currSum -= node.val;
			} else if (found.contains(node.left) || found.contains(node.right)) {
				found.add(node);
				stack.pop();
				currSum = (currSum - node.val) / 10;
			} else {
				if (node.right != null) {
					stack.push(node.right);
				}

				if (node.left != null) {
					stack.push(node.left);
				}
			}
		}

		return sum;
	}


	// A much more concise one learn from others
	public int sumNumbers2(TreeNode root) {
		if (root == null) { return 0; }

		return helper(root, 0);
	}

	public int helper(TreeNode node, int curr) {
		if (node.left == null && node.right == null) {
			return curr * 10 + node.val;
		}

		int sum = 0;

		if (node.left != null) {
			sum += helper(node.left, curr * 10 + node.val);
		}

		if (node.right != null) {
			sum += helper(node.right, curr * 10 + node.val);
		}

		return sum;
	}
}
