/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int tmp = 0;
        int a = x;
        while (a > 0) {
            int b = a % 10;
            tmp = tmp * 10 + b;
            a = a / 10;
        }

        return x == tmp;
    }
}
// @lc code=end