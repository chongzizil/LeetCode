package com.li.zil.leetcode;

import com.li.zil.leetcode.datastructure.TreeLinkNode;

import java.util.ArrayDeque;

/**
 * Created by Zil on 2014/7/22.
 */
public class PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		ArrayDeque<TreeLinkNode> firstQueue = new ArrayDeque<TreeLinkNode>();
		ArrayDeque<TreeLinkNode> secondQueue = new ArrayDeque<TreeLinkNode>();
		int numberOfNodesOfLayer = 1;
		if (root == null) {
			return;
		}

		firstQueue.addLast(root);

		while(!firstQueue.isEmpty()) {
			TreeLinkNode nextNode = null;
			for (int i = 0; i < numberOfNodesOfLayer; i++) {
				TreeLinkNode node = firstQueue.pollLast();
				if (node.left != null || node.right != null) {
					secondQueue.addFirst(node.right);
					secondQueue.addFirst(node.left);
				}

				node.next = nextNode;
				nextNode = node;
			}
			firstQueue = secondQueue.clone();
			secondQueue.clear();
			numberOfNodesOfLayer *= 2;
		}
	}
}
