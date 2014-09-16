package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/8/10.
 */
public class MinimumDepthofBinaryTree {
	// Be careful of the conner cases.
	public int minDepth(TreeNode root) {
		if (root == null) { return 0; }
		return traverse(root);
	}

	public int traverse(TreeNode node) {
		if (node.left == null && node.right == null) {
			return 1;
		}

		int left = Integer.MAX_VALUE;
		int right = Integer.MAX_VALUE;

		if (node.left != null) {
			left = traverse(node.left) + 1;
		}

		if (node.right != null) {
			right = traverse(node.right) + 1;
		}

		return Math.min(left, right);
	}
}
