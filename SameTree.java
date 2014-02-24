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
    boolean isSameTreeHelper(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        // Be aware of (p.val == q.val && p != null && q != null)
        } else if (p != null && q != null && p.val == q.val) {
            return isSameTreeHelper(p.left, q.left) && isSameTreeHelper(p.right, q.right);
        } else {
            return false;
        }
    }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeHelper(p ,q);
    }
}