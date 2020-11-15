/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) {
            return 0;
        }

        int y = x > 0 ? x : -x;
        int ans = 0;
        while (y > 0) {
            int a = y % 10;
            if ((Integer.MAX_VALUE - a) / 10 < ans) {
                return 0;
            } 
            ans = ans * 10 + a;
            y /= 10;
        }

        return x > 0 ? ans : -ans;
    }
}
// @lc code=end