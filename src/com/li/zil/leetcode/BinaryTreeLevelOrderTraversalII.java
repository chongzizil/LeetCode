package com.li.zil.leetcode;

import java.util.*;

/**
 * Created by Zil on 2014/8/7.
 */
public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<List<TreeNode>> levelNodes = new ArrayList<List<TreeNode>>();
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();

		if (root == null) {
			return res;
		}

		queue.addLast(root);

		while (!queue.isEmpty()) {
			List<TreeNode> tmpNodes = new ArrayList<TreeNode>();
			while (!queue.isEmpty()) {
				TreeNode node = queue.pollFirst();
				tmpNodes.add(node);
			}

			for (TreeNode node : tmpNodes) {
				if (node.left != null) {
					queue.addLast(node.left);
				}
				if (node.right != null) {
					queue.addLast(node.right);
				}
			}

			levelNodes.add(tmpNodes);
		}

		for (int i = levelNodes.size() - 1; i >= 0; i--) {
			List<TreeNode> tmpNodes = levelNodes.get(i);
			List<Integer> tmpValues = new ArrayList<Integer>();
			for (TreeNode node : tmpNodes) {
				tmpValues.add(node.val);
			}
			res.add(tmpValues);
		}

		return res;
	}

	// Optimized by taking the advantage of the linked list of JAVA. Therefore there's no need
	// to reverse the res, simply insert each level's result to the head of the linked list.
	public List<List<Integer>> levelOrderBottom2(TreeNode root) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();

		if (root == null) { return res; }

		queue.addLast(root);

		while(!queue.isEmpty()) {
			List<Integer> tmpValues = new ArrayList<Integer>();
			List<TreeNode> tmpNodes = new ArrayList<TreeNode>();

			while(!queue.isEmpty()) {
				TreeNode node = queue.pollFirst();
				tmpValues.add(node.val);
				tmpNodes.add(node);
			}

			for(TreeNode node : tmpNodes) {
				if(node.left != null) { queue.addLast(node.left); }
				if(node.right != null) { queue.addLast(node.right); }
			}

			res.add(0, tmpValues);
		}

		return res;
	}
}
