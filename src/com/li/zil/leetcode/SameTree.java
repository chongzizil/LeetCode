package com.li.zil.leetcode;

/**
 *
 */
public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		return helper(p, q);
	}

	public boolean helper(TreeNode p, TreeNode q) {
		if (p == null & q == null) {
			return true;
		} else if (p != null && q != null && isSameNode(p, q)) {
			return helper(p.left, q.left) && helper(p.right, q.right);
		}

		return false;
	}

	public boolean isSameNode(TreeNode p, TreeNode q) {
		return p.val == q.val;
	}
}
