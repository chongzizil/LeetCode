package com.li.zil.leetcode.tree;

import com.li.zil.leetcode.datastructure.TreeNode;

public class HasPath {
  int sum;

  public boolean hasPathSumA(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }

    this.sum = sum;

    return helperA(root, 0);
  }

  private boolean helperA(TreeNode node, int currSum) {
    if (node == null) {
      return false;
    } else if (node.left == null && node.right == null) {
      return currSum + node.val == sum;
    }

    return helperA(node.left, currSum + node.val) || helperA(node.right, currSum + node.val);
  }

  public boolean hasPathSumB(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    if (root.left == null && root.right == null) {
      return sum == root.val;
    }
    return hasPathSumB (root.left, sum - root.val)
        || hasPathSumB(root.right, sum - root.val);
  }
}
