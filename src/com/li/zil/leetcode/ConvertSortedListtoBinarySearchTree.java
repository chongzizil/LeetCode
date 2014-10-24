package com.li.zil.leetcode;

import com.li.zil.leetcode.datastructure.TreeNode;

/**
 * Created by Zil on 2014/9/16.
 */
public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		int length = 0;
		ListNode node = head;

		if (node == null) {
			return null;
		}

		while (node != null) {
			node = node.next;
			length++;
		}

		return helper(head, 0, length - 1);
	}

	public TreeNode helper(ListNode node, int low, int high) {
		ListNode lowNode = node;
		ListNode midNode = node;

		if (low > high) {
			return null;
		}

		int mid = (high - low)/2 + low;
		for (int i = low; i < mid; i++) {
			midNode = midNode.next;
		}

		TreeNode treeNode = new TreeNode(midNode.val);
		treeNode.left = helper(lowNode, low, mid - 1);
		treeNode.right = helper(midNode.next, mid + 1, high);

		return treeNode;
	}

	// This is a bottom up solution with O(n) running time
	// Learned from http://leetcode.com/2010/11/convert-sorted-list-to-balanced-binary.html

	public TreeNode sortedListToBST2(ListNode head) {
		int n = 0;
		ListNode node = head;

		while (node != null) {
			node = node.next;
			n++;
		}

		return helper2(head, 0, n - 1);
	}

	public TreeNode helper2(ListNode list, int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = start + (end - start) / 2;

		TreeNode leftChild = helper2(list, start, mid - 1);
		TreeNode parent = new TreeNode(list.val);
		parent.left = leftChild;
		if (list.next != null) {
			list.val = list.next.val;
			list.next = list.next.next;
		}
		parent.right = helper2(list, mid + 1, end);
		return parent;
	}
}
