package com.li.zil.leetcode;

import com.li.zil.leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by Zil on 2014/8/7.
 */
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Deque<TreeNode> queue = new ArrayDeque<TreeNode>();

		if (root == null) { return res; }

		queue.addLast(root);

		while(!queue.isEmpty()) {
			List<Integer> tmpValueList = new ArrayList<Integer>();
			List<TreeNode> tmpNodeList = new ArrayList<TreeNode>();

			while(!queue.isEmpty()) {
				TreeNode node = queue.pollFirst();
				tmpValueList.add(node.val);
				tmpNodeList.add(node);
			}

			for(TreeNode node : tmpNodeList) {
				if(node.left != null) { queue.addLast(node.left); }
				if(node.right != null) { queue.addLast(node.right); }
			}

			res.add(tmpValueList);
		}

		return res;
	}
}
