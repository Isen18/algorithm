/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return doBuildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode doBuildTree(int[] inorder, int i, int j, int[] postorder, int s, int t) {
        if (i == j) {
            return new TreeNode(inorder[i]);
        }

        if (i > j) {
            return null;
        }

        int rootValue = postorder[t];
        int rootIdx = -1;
        for (int r = i; r <= j; r++) {
            if (inorder[r] == rootValue) {
                rootIdx = r;
                break;
            }
        }

        int leftNum = rootIdx - i;
        int rightNum = j - rootIdx;
        TreeNode left = doBuildTree(inorder, i, rootIdx - 1, postorder, s, s + leftNum - 1);
        TreeNode right = doBuildTree(inorder, rootIdx + 1, j, postorder, t - rightNum, t - 1);
        TreeNode root = new TreeNode(rootValue, left, right);

        return root;
    }
}
// @lc code=end

