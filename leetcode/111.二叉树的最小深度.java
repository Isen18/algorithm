/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = 0;
        int rightDepth = 0;
        if (root.left != null) {
            leftDepth = minDepth(root.left);
        }

        if (root.right != null) {
            rightDepth = minDepth(root.right);
        }

        if (leftDepth == 0) {
            return rightDepth + 1;
        }

        if (rightDepth == 0) {
            return leftDepth + 1;
        }

        return leftDepth < rightDepth ? leftDepth + 1 : rightDepth + 1;
    }
}
// @lc code=end