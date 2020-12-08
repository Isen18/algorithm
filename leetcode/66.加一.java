/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length + 1];
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int tmp = digits[i] + carry;
            if (tmp > 9) {
                tmp -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            res[i + 1] = tmp;
        }

        if (carry == 1) {
            res[0] = 1;
            return res;
        }

        int[] ans = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            ans[i] = res[i + 1];
        }

        return ans;
    }
}
// @lc code=end