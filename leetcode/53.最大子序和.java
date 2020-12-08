/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0 ) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }

            if (sum > res) {
                res = sum;
            }
        }

        return res;
    }
}
// @lc code=end