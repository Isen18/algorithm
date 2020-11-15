/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int tail = 0;
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i  - 1]) {
                nums[tail + 1] = nums[i];
                tail++;
                len++;
            }
        }

        return len;
    }
}
// @lc code=end