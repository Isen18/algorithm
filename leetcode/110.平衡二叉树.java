/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int depth0(TreeNode node) {
      if (node == null) {
        return 0;
      }

      int ld = depth(node.left);
      if (ld == -1) {
        return -1;
      }

      int rd = depth(node.right);
      if (rd == -1) {
        return -1;
      }

      if ((ld - rd >= -1) && (ld - rd <= 1)) {
        //平衡
        return ld > rd ? ld + 1 : rd + 1;
      }

      return -1;
    }

    private int depth(TreeNode root) {
      if (root == null) {
          return 0;
      }

      int leftDepth = depth(root.left);
      int rightDepth = depth(root.right);
      if (leftDepth >= 0 && rightDepth >= 0 && Math.abs(leftDepth - rightDepth) <= 1) {
          return Math.max(leftDepth, rightDepth) + 1;
      }

      return -1;
    }

    public boolean isBalanced(TreeNode root) {
      //后序遍历
      int depth = depth(root);
      return depth != -1;
    }
}
// @lc code=end

