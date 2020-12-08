import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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

    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        // doInorderTraversal(root);
        doInorderTraversalLoop(root);
        return res;
    }

    private void doInorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        doInorderTraversal(root.left);
        res.add(root.val);
        doInorderTraversal(root.right);
    }

    private void doInorderTraversalLoop(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null) {
            stack.push(p);
            p = p.left;
        }

        while (!stack.isEmpty()) {
            p = stack.pop();
            res.add((p.val));
            p = p.right;
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
        }
    }
}
// @lc code=end