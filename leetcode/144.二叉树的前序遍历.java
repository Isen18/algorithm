import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    List<Integer> res;

    public List<Integer> preorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        doPreorderTraversal(root);

        return res;
    }

    private void doPreorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        doPreorderTraversal(root.left);
        doPreorderTraversal(root.right);
    }

    private void doPreorderTraversalLoop(TreeNode root) {
        if (root == null) {
            return;
        }

        //存父节点
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                res.add(p.val);
                stack.push(p);
                p = p.left;
            }

            p = stack.pop();
            p = p.right;
        }
    }
}
// @lc code=end