package com.li.zil.leetcode;

import com.li.zil.leetcode.datastructure.TreeNode;

/**
 * Created by Zil on 2014/7/24.
 */
public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		return helper(num, 0, num.length - 1);
	}

	public TreeNode helper(int[] num, int low, int high) {
		if (low > high) {
			return null;
		}

		int mid = (high + low) / 2;
		TreeNode node = new TreeNode(num[mid]);

		node.left = helper(num, low, mid - 1);
		node.right = helper(num, mid + 1, high);

		return node;
	}
}
