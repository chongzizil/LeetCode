package com.li.zil.leetcode;

/**
 *
 */
public class MaximumDepthOfBinaryTree {
	public int maxDepth(TreeNode root) {
		return helper(root);
	}

	public int helper(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return max(helper(node.left) + 1, helper(node.right) + 1);
	}

	public int max(int i, int j) {
		return i > j ? i : j;
	}
}
