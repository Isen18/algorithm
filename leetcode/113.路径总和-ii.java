import java.util.List;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        doPathSum(root, targetSum, new ArrayList<>());

        return res;
    }

    private void doPathSum(TreeNode root, int targetSum, List<Integer> tmpList) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && root.val == targetSum) {
            List<Integer> item = new ArrayList<>(tmpList);
            item.add(root.val);
            res.add(item);
            return;
        }

        tmpList.add(root.val);
        doPathSum(root.left, targetSum - root.val, tmpList);
        doPathSum(root.right, targetSum - root.val, tmpList);
        tmpList.remove(tmpList.size() - 1);
    }
}
// @lc code=end

