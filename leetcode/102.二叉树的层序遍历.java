import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] 二叉树的层序遍历
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> items = new ArrayList<>();
            int len = queue.size();
            while (len-- > 0) {
                TreeNode node = queue.remove(0);
                items.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            res.add(items);
        }

        return res;
    }
}
// @lc code=end