package com.li.zil.leetcode;

import com.li.zil.leetcode.datastructure.TreeNode;

import java.util.*;

/**
 * Created by Zil on 2014/8/9.
 */
public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
		Set<TreeNode> hasFound = new HashSet<TreeNode>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (root == null) { return res; }

		stack.push(root);

		while(!stack.isEmpty()) {
			TreeNode node = stack.peek();

			if (node.left == null && node.right == null) {
				hasFound.add(node);

				if (sum - node.val == 0) {
					queue.addLast(node);
					res.add(record(queue));
					queue.pollLast();
				}

				stack.pop();
			} else {
				if (hasFound.contains(node.left) || hasFound.contains(node.right)) {
					sum += node.val;
					hasFound.add(node);
					stack.pop();
					queue.pollLast();
				} else {
					sum -= node.val;
					queue.addLast(node);

					if (node.right != null) {
						stack.push(node.right);
					}

					if (node.left != null) {
						stack.push(node.left);
					}
				}
			}
		}

		return res;
	}

	public List<Integer> record(Deque<TreeNode> queue) {
		List<Integer> tmpList = new ArrayList<Integer>();
		for (TreeNode node : queue) {
			tmpList.add(node.val);
		}

		return tmpList;
	}
}
