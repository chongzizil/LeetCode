package com.li.zil.leetcode;

import com.li.zil.leetcode.datastructure.TreeNode;

/**
 * Created by Zil on 2014/9/13.
 */
public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		while (root != null) {
			if (root.left != null) {
				TreeNode rightMostNode = root.left;
				while (rightMostNode.right != null) {
					rightMostNode = rightMostNode.right;
				}
				rightMostNode.right = root.right;

				root.right = root.left;
				root.left = null;
			}

			root = root.right;
		}
	}
}
