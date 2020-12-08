/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int a = 1;
        int b = 2;
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = a + b;
            a = b;
            b = res;
        }

        return res;
    }
}
// @lc code=end