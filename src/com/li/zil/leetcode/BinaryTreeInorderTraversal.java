package com.li.zil.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zil on 2014/7/15.
 */
public class BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
		List<TreeNode> hasSeenNodes = new ArrayList<TreeNode>();
		List<Integer> result = new ArrayList<Integer>();

		if (root == null) {
			return result;
		}

		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode peekNode = stack.peek();
			if (!hasSeenNodes.contains(peekNode) && peekNode.left != null) {
				stack.push(peekNode.left);
				hasSeenNodes.add(peekNode);
			} else {
				TreeNode node = stack.pop();
				result.add(node.val);
				if (node.right != null) {
					stack.push(node.right);
				}
			}
		}

		return result;
	}
}
