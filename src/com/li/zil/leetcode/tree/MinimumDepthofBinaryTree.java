package com.li.zil.leetcode.tree;

import com.li.zil.leetcode.datastructure.TreeNode;

public class MinimumDepthofBinaryTree {
  // A refactor of solution B
  public int minDepthA(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return getMinDepthA(root);
  }

  private int getMinDepthA(TreeNode node) {
    if (node == null) {
      return Integer.MAX_VALUE;
    }

    if (node.left == null && node.right == null) {
      return 1;
    }

    return Math.min(getMinDepthA(node.left), getMinDepthA(node.right)) + 1;
  }


  public int minDepthB(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return getMinDepthB(root);
  }

  private int getMinDepthB(TreeNode node) {
    int min = Integer.MAX_VALUE;

    if (node.left == null && node.right == null) {
      return 1;
    }

    if (node.left != null) {
      min = getMinDepthB(node.left);
    }

    if (node.right != null) {
      min = Math.min(min, getMinDepthB(node.right));
    }

    return min + 1;
  }

	// Be careful of the conner cases.
	public int minDepthC(TreeNode root) {
		if (root == null) { return 0; }
		return traverseC(root);
	}

	public int traverseC(TreeNode node) {
		if (node.left == null && node.right == null) {
			return 1;
		}

		int left = Integer.MAX_VALUE;
		int right = Integer.MAX_VALUE;

		if (node.left != null) {
			left = traverseC(node.left) + 1;
		}

		if (node.right != null) {
			right = traverseC(node.right) + 1;
		}

		return Math.min(left, right);
	}
}
