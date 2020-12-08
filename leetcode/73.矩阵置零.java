import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=73 lang=java
 *
 * [73] 矩阵置零
 */

// @lc code=start
class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int len = m < n ? m : n;
        Set<Integer> set = new HashSet<>(len);
        for (int i = 0; i < m; i++) {
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    set.add(j);
                    flag = true;
                }
            }
            
            if (flag) {
                for (int k = 0; k < n; k++) {
                    matrix[i][k] = 0;
                }
            }
        }

        for (int j : set) {
            for (int i = 0; i < m; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}
// @lc code=end