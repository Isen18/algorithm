/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除排序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (idx < 2 || nums[idx - 2] != nums[i]) {
                nums[idx++] = nums[i];
            }
        }

        return idx;
    }
}
// @lc code=end

