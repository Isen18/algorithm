/*
 * @lc app=leetcode.cn id=231 lang=java
 *
 * [231] 2的幂
 */

// @lc code=start
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        if (n == Integer.MIN_VALUE) {
            return false;
        }

        n &= (n - 1);
        return n == 0;
    }
}
// @lc code=end