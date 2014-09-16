package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/8/8.
 */
public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) { return false; }

		return helper(root, sum, false);
	}

	public boolean helper(TreeNode node, int num, boolean isLeaf) {
		if (node == null) {
			return num == 0 && isLeaf;
		}

		if (node.left == null && node.right == null) {
			isLeaf = true;
		}

		return helper(node.left, num - node.val, isLeaf) || helper(node.right, num - node.val, isLeaf);
	}

	//
	public boolean hasPathSum2(TreeNode root, int sum) {
		if(root == null) { return false; }

		return helper2(root, sum);
	}

	public boolean helper2(TreeNode node, int num) {
		if (node == null) { return false; }

		if (node.left == null && node.right == null) {
			return num - node.val == 0;
		}

		return helper2(node.left, num - node.val) || helper2(node.right, num - node.val);
	}
}
