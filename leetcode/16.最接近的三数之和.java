/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
class Solution {
    private int res;

    public int threeSumClosest(int[] nums, int target) {
        res = nums[0] + nums[1] + nums[2];

        com(nums, 0, 3, 0, target);

        return res;
    }

    private void com(int[] nums, int k, int n, int sum, int target) {
        if (n == 0) {
            if (Math.abs(sum - target) < Math.abs(res - target)) {
                res = sum;
            }

            return;
        }

        if (k == nums.length) {
            return;
        }

        //选择
        com(nums, k + 1, n - 1, sum + nums[k], target);

        //不选择
        com(nums, k + 1, n, sum, target);
    }

    
}
// @lc code=end

