package com.li.zil.leetcode;

import com.li.zil.leetcode.datastructure.TreeNode;

import java.util.*;

/**
 * Created by Zil on 2014/8/7.
 */
public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		Deque<TreeNode> nodesStack = new ArrayDeque<TreeNode>();
		List<Integer> res = new ArrayList<Integer>();
		Set<TreeNode> foundSet = new HashSet<TreeNode>();

		if (root == null) { return res; }

		nodesStack.addFirst(root);

		while(!nodesStack.isEmpty()) {
			TreeNode node = nodesStack.getFirst();

			if ( (node.right == null && node.left == null)
					|| foundSet.contains(node.right)
					|| foundSet.contains(node.left) ) {
				nodesStack.removeFirst();
				foundSet.add(node);
				res.add(node.val);
			} else if (node.right != null || node.left != null) {
				if (node.right != null) {
					nodesStack.addFirst(node.right);
				}
				if (node.left != null) {
					nodesStack.addFirst(node.left);
				}
			}
		}

		return res;
	}
}
