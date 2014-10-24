package com.li.zil.leetcode;

import com.li.zil.leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;

/**
 * Created by Zil on 2014/7/23.
 */
public class SymmetricTree {
	// A recursive solution
	public boolean isSymmetric(TreeNode root) {
		if (root == null || (root.left == null && root.right == null)) { return true; }

		return helper(root.left, root.right);
	}

	public boolean helper(TreeNode leftHalf, TreeNode rightHalf) {
		if (leftHalf == null && rightHalf == null) { return true; }
		if (leftHalf == null ^ rightHalf == null) { return false; }
		if (helper(leftHalf.left, rightHalf.right) && helper(leftHalf.right, rightHalf.left)) {
			if (leftHalf.val == rightHalf.val) {
				return true;
			}
		}
		return false;
	}

	// A recursive solution with better codes...
	public boolean isSymmetric2(TreeNode root) {
		if (root == null) { return true; }

		return helper(root.left, root.right);
	}

	public boolean helper2(TreeNode leftHalf, TreeNode rightHalf) {
		if (leftHalf == null && rightHalf == null) { return true; }
		if (leftHalf == null || rightHalf == null) { return false; }
		if (leftHalf.val == rightHalf.val) { return false; }
		return helper(leftHalf.left, rightHalf.right) && helper(leftHalf.right, rightHalf.left);
	}

	// A iterative solution :)
	public boolean isSymmetric3(TreeNode root) {
		ArrayDeque<TreeNode> leftHalf = new ArrayDeque<TreeNode>();
		ArrayDeque<TreeNode> rightHalf = new ArrayDeque<TreeNode>();

		if (root == null || (root.left == null && root.right == null)) { return true; }

		if (root.left == null || root.right == null) { return false; }

		leftHalf.push(root.left);
		rightHalf.push(root.right);

		while (!leftHalf.isEmpty() || !rightHalf.isEmpty()) {
			TreeNode node1 = leftHalf.pop();
			TreeNode node2 = rightHalf.pop();
			if (node1 == null && node2 == null) { continue; }
			if (node1 == null || node2 == null) { return false; }
			if (node1.val != node2.val) { return false; }

			if (node1.left == null ^ node2.right == null) {
				return false;
			} else if (!(node1.left == null && node2.right == null)) {
				leftHalf.push(node1.left);
				rightHalf.push(node2.right);
			}

			if (node1.right == null ^ node2.left == null) {
				return false;
			} else if (!(node1.right == null && node2.left == null)) {
				leftHalf.push(node1.right);
				rightHalf.push(node2.left);
			}
		}

		return true;
	}
}
