package com.li.zil.leetcode;

import com.li.zil.leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Zil on 2014/7/29.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        Deque<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();

        if (root == null) { return true; }

        nodeQueue.addLast(root);

        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.pollFirst();
            if (Math.abs(depth(node.left) - depth(node.right)) > 1) {
                return false;
            } else {
                if (node.left != null) {
                    nodeQueue.addLast(node.left);
                }
                if (node.right != null) {
                    nodeQueue.addLast(node.right);
                }
            }
        }

        return true;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }

    // A solution with only one recursion
    public  boolean isBalanced2(TreeNode root) {
        int[] isBalanced = new int[]{1};
        if (root == null) { return true; }

        helper(isBalanced, root);

        return isBalanced[0] == 1 ? true : false;
    }

    public  int helper(int[] isBanlanced, TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = helper(isBanlanced, node.left);
        int rightDepth = helper(isBanlanced, node.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBanlanced[0] = 0;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }

    // A slight different version

    boolean isBalanced = true;

    public  boolean isBalanced3(TreeNode root) {
        if (root == null) { return true; }

        helper3(isBalanced, root);

        return isBalanced;
    }

    public  int helper3(boolean isBanlanced, TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = helper3(isBanlanced, node.left);
        int rightDepth = helper3(isBanlanced, node.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBalanced = false;
        }

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
