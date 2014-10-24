package com.li.zil.leetcode.datastructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}

	public static int getDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return Math.max(getDepth(node.left) + 1, getDepth(node.right) + 1);
	}

	public static void preOrderRecursiveTraverse(TreeNode node) {
		if (node == null) {
			return;
		}

		System.out.print(node.val + " ");

		preOrderRecursiveTraverse(node.left);

		preOrderRecursiveTraverse(node.right);
	}

	public static void inOrderRecursiveTraverse(TreeNode node) {
		if (node == null) {
			return;
		}

		inOrderRecursiveTraverse(node.left);

		System.out.print(node.val + " ");

		inOrderRecursiveTraverse(node.right);
	}

	public static void postOrderRecursiveTraverse(TreeNode node) {
		if (node == null) {
			return;
		}

		postOrderRecursiveTraverse(node.left);

		postOrderRecursiveTraverse(node.right);

		System.out.print(node.val + " ");
	}

	public static void preOrderIterativeTraverse_A(TreeNode node) {
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

		if (node == null) {
			return;
		}

		stack.push(node);

		while (!stack.isEmpty()) {
			TreeNode tmpNode = stack.pop();
			System.out.print(tmpNode.val + " ");

			if (tmpNode.right != null) {
				stack.push(tmpNode.right);
			}

			if (tmpNode.left != null) {
				stack.push(tmpNode.left);
			}
		}

		return;
	}

	public static void preOrderIterativeTraverse_B(TreeNode node) {
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

		if (node == null) {
			return;
		}

		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				System.out.print(node.val + " ");
				if (node.right != null) {
					stack.push(node.right);
				}
				node = node.left;
			} else {
				node = stack.pop();
			}
		}

		return;
	}

	public static void inOrderIterativeTraverse_A(TreeNode node) {
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		List<TreeNode> hasSeen = new ArrayList<TreeNode>();

		if (node == null) {
			return;
		}

		stack.push(node);

		while (!stack.isEmpty()) {
			TreeNode tmpNode = stack.peek();
			if (tmpNode.left != null && !hasSeen.contains(tmpNode)) {
				stack.push(tmpNode.left);
				hasSeen.add(tmpNode);
			} else {
				System.out.print(tmpNode.val + " ");
				stack.pop();
				if (tmpNode.right != null) {
					stack.push(tmpNode.right);
				}
			}
		}

		return;
	}

	public static void inOrderIterativeTraverse_B(TreeNode node) {
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();

		if (node == null) {
			return;
		}

		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				System.out.print(node.val + " ");
				node = node.right;
			}
		}

		return;
	}

	public static void postOrderIterativeTraverse(TreeNode node) {
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		List<TreeNode> hasSeenNodes = new ArrayList<TreeNode>();

		if (node == null) {
			return;
		}

		stack.push(node);

		while (!stack.isEmpty()) {
			TreeNode tmpNode = stack.peek();
			if (tmpNode.left != null && !hasSeenNodes.contains(tmpNode.left)) {
				stack.push(tmpNode.left);
				hasSeenNodes.add(tmpNode.left);
			} else if (tmpNode.right != null && !hasSeenNodes.contains(tmpNode.right)) {
				stack.push(tmpNode.right);
				hasSeenNodes.add(tmpNode.right);
			} else {
				System.out.print(tmpNode + " ");
				stack.pop();
			}
		}

		return;
	}

	public static void postOrderIterativeTraverse_B(TreeNode node) {
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		TreeNode lastVisitedNode = null;

		if (node == null) {
			return;
		}

		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				TreeNode tmpNode = stack.peek();
				if (tmpNode.right != null && lastVisitedNode != tmpNode.right) {
					node = tmpNode.right;
				} else {
					stack.pop();
					System.out.print(tmpNode + " ");
					lastVisitedNode = tmpNode;
				}
			}
		}

		return;
	}
}
