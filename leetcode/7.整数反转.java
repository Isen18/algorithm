/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse0(int x) {
        if (x == Integer.MIN_VALUE) {
            //不是很通用
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

    public int reverse(int x) {
        int y = x;
        int ans = 0;
        while (y != 0) {
            int a = y % 10;
            if (y > 0 && (Integer.MAX_VALUE - a) / 10 < ans) {
                return 0;
            } else if (y < 0 && (Integer.MIN_VALUE - a) / 10 > ans) {
                return 0;
            }
            ans = ans * 10 + a;
            y /= 10;
        }

        return ans;
    }
}
// @lc code=end