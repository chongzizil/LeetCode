package com.li.zil.leetcode.tree;

import com.li.zil.leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConstructBinaryTreeFromPreorderandInorderTraversal {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder.length == 0) {
      // Assume both the preorder array and the inorder array are legal
      return null;
    }

    Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
    TreeNode dummy = new TreeNode(0);
    stack.push(dummy);
    int n = preorder.length;
    int i = 0;
    int j = 0;

    while (i < n) {
      if (i == 0 || stack.size() == 1 || inorder[j] != stack.peek().val) {
        // Phase 1: If the node's val on the top of the stack does not equal to inorder[j].
        //          It means that current node(i) will be a new node as the left child of
        //          the node on the top of the stack.
        //
        // I use a dummy node for convenience, the root will always be the dummy's left child.
        TreeNode newNode = new TreeNode(preorder[i]);
        TreeNode parentNode = stack.peek();
        parentNode.left = newNode;
        stack.push(newNode);
        i++;
      } else {
        // Phase 2: If the node's val on the top of the stack equals to inorder[j]. This means
        //          that the current node(i) will be a node X's right child. To identify node X,
        //          pop a node from the stack if it's value equals to inorder[j] until it stops.
        //          The last popped node shall be node X.
        //
        // There might be no right child node...
        TreeNode root = stack.peek();
        while (stack.size() > 1 && inorder[j] == stack.peek().val) {
          root = stack.pop();
          j++;
        }

        if (i < n) {
          TreeNode rightNode = new TreeNode(preorder[i]);
          root.right = rightNode;
          stack.push(rightNode);
          i++;
        }

      }
    }

    return dummy.left;
  }
}
