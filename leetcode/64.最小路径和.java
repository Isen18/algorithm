/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid[0].length;
        int[] tmp = new int[n];
        tmp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            tmp[i] = tmp[i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            tmp[0] += grid[i][0];
            for (int j = 1; j < n; j++) {
                tmp[j] = Math.min(tmp[j - 1], tmp[j]) + grid[i][j];
            }
        }

        return tmp[n - 1];
    }
}
// @lc code=end