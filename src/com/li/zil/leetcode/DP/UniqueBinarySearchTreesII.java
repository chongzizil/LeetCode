package com.li.zil.leetcode.DP;

import com.li.zil.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
  // This is an DP solution. For each possible root node, generate all possible left tree
  // and right tree first... Do this recursively...
  public List<TreeNode> generateTrees(int n) {
    return helper(1, n);
  }

  private List<TreeNode> helper(int start, int end) {
    List<TreeNode> res = new ArrayList<TreeNode>();

    if (start > end) {
      res.add(null);
      return res;
    }

    for (int i = start; i <= end; i++) {
      List<TreeNode> left = helper(start, i - 1);
      List<TreeNode> right = helper(i + 1, end);

      for (TreeNode leftNode : left) {
        for (TreeNode rightNode : right) {
          TreeNode root = new TreeNode(i);
          root.left = leftNode;
          root.right = rightNode;
          res.add(root);
        }
      }
    }

    return res;
  }
}
