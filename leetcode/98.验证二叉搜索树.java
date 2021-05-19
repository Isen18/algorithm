/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode last;
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean re = isValidBST(root.left);
        if (!re) {
            return false;
        }

        if (last != null && last.val >= root.val) {
            return false;
        }

        last = root;
        return isValidBST(root.right);
    }

}
// @lc code=end

