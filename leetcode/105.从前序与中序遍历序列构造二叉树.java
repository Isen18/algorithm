/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return doBuildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode doBuildTree(int[] preorder, int i, int j, int[] inorder, int s, int t) {
        if (i == j) {
            return new TreeNode(preorder[i]);
        }

        if (i > j) {
            return null;
        }

        int rootValue = preorder[i];
        int rootIdx = -1;
        for (int r = s; r <= t; r++) {
            if (inorder[r] == rootValue) {
                rootIdx = r;
                break;
            }
        }

        int leftLen = rootIdx - s;
        TreeNode left = doBuildTree(preorder, i + 1, i + leftLen, inorder, s, rootIdx - 1);
        TreeNode right = doBuildTree(preorder, i + leftLen + 1, j, inorder, rootIdx + 1, t);
        TreeNode root = new TreeNode(rootValue, left, right);

        return root;
    }
}
// @lc code=end

