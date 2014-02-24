/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int max(int a, int b) {
        return a > b ? a : b;
    }
    
    private int maxDepthHelper(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        return max(maxDepthHelper(node.left, depth + 1), maxDepthHelper(node.right, depth + 1));
    }
    
    public int maxDepth(TreeNode root) {
        return maxDepthHelper(root, 0);
    }
}