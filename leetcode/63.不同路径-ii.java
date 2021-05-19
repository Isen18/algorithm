/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int n = obstacleGrid[0].length;
        int[] tmp = new int[n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }

            tmp[i] = 1;
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                tmp[0] = 0;
            }

            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    tmp[j] = 0;
                    continue;
                }

                tmp[j] += tmp[j - 1];
            }
        }

        return tmp[n - 1];
    }
}
// @lc code=end