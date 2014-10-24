package com.li.zil.leetcode;

import com.li.zil.leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Preorder traversal
 */
public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
		if (root != null) {
			stack.push(root);

			while (!stack.isEmpty()) {
				TreeNode node = stack.pop();
				result.add(node.val);
				if (node.right != null) {
					stack.push(node.right);
				}
				if (node.left != null) {
					stack.push(node.left);
				}
			}
		}

		return result;
	}
}
