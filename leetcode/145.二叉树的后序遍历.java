import java.util.ArrayList;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] 二叉树的后序遍历
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

    public List<Integer> postorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        doPostorderTraversal(root);
        // doPostorderTraversalLoop(root);
        return res;
    }

    private void doPostorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        doPostorderTraversal(root.left);
        doPostorderTraversal(root.right);
        res.add(root.val);
    }

    private void doPostorderTraversalLoop(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        //表示已经访问过的节点
        TreeNode p2;
        while (p != null) {
            while (p != null) {
                //所有左节点入栈
                stack.push(p);
                p = p.left;
            }

            p2 = null;
            boolean visLeft = true;
            while (!stack.isEmpty() && visLeft) {
                p = stack.pop();
                if (p.right == p2) {
                    //p的右孩子为 null 或p的右孩子刚访问过，则可以访问p
                    res.add(p.val);
                    p2 = p;
                    continue;
                } 

                //p的右孩子还未访问过
                stack.push(p);
                p = p.right;
                if (p != null) {
                    visLeft = false;
                } else {
                    p2 = null;
                }
            }

        }
    }
}
// @lc code=end