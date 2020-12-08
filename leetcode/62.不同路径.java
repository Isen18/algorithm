/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 */

// @lc code=start
class Solution {
    // public int uniquePaths(int m, int n) {
    //     int[][] dp = new int[m][n];
    //     for (int i = 0; i < n; i++) dp[0][i] = 1;
    //     for (int i = 0; i < m; i++) dp[i][0] = 1;
    //     for (int i = 1; i < m; i++) {
    //         for (int j = 1; j < n; j++) {
    //             dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    //         }
    //     }
    //     return dp[m - 1][n - 1];  
    // }

    // public int uniquePaths(int m, int n) {
    //     int[][] tmp = new int[2][n];

    //     for (int i = 0; i < n; i++) {
    //         tmp[0][i] = 1;
    //     }
        
    //     int pre = 0;
    //     int cur = 1;
    //     for (int i = 1; i < m; i++) {
    //         tmp[cur][0] = 1;
    //         for (int j = 1; j < n; j++) {
    //             tmp[cur][j] = tmp[pre][j] + tmp[cur][j - 1];
    //         }
    //         pre = cur;
    //         cur = 1 - pre;
    //     }

    //     return tmp[pre][n - 1];
    // }

    public int uniquePaths(int m, int n) {
        int[] tmp = new int[n];

        for (int i = 0; i < n; i++) {
            tmp[i] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                tmp[j] += tmp[j - 1];
            }
        }

        return tmp[n - 1];
    }
}
// @lc code=end