/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
    public void flatten(TreeNode root) {
        doFlatten(root);
    }

    private TreeNode doFlatten(TreeNode root) {
        if (root == null) {
            return root;
        }

        //访问root
        TreeNode right = root.right;
        root.right = root.left;
        doFlatten(root.left);
        
        doFlatten(root.right);
    }
}
// @lc code=end