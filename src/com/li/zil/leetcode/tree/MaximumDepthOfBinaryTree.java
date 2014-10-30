package com.li.zil.leetcode.tree;

import com.li.zil.leetcode.datastructure.TreeNode;

public class MaximumDepthOfBinaryTree {
  public int maxDepth(TreeNode root) {
    return getMaxDepth(root);
  }

  private int getMaxDepth(TreeNode node) {
    if (node == null) {
      return 0;
    }

    return Math.max(getMaxDepth(node.left), getMaxDepth(node.right)) + 1;
  }
}
