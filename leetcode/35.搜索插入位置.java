/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        //寻找第一个 >= target的数
        int s = 0;
        int t = nums.length - 1;
        while (s <= t) {
            int mid = (s + t) >> 1;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                s = mid + 1;
                continue;
            }

            if (mid == 0) {
                return 0;
            }

            if (nums[mid - 1] < target) {
                return mid;
            }

            t = mid - 1;            
        }

        return nums.length;
    }
}
// @lc code=end