/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, 0, nums.length - 1, target);
        int last = findLast(nums, 0, nums.length - 1, target);
        return new int[]{first, last};
    }

    private int findFirst(int[] nums, int s, int t, int target) {
        if (s > t) {
            return -1;
        }

        int mid = (t + s) >> 1;
        if (nums[mid] < target) {
            return findFirst(nums, mid + 1, t, target);
        } else if (nums[mid] > target) {
            return findFirst(nums, s, mid - 1, target);
        }

        if (mid == 0) {
            return 0;
        }

        if (nums[mid] != nums[mid - 1]) {
            return mid;
        }

        return findFirst(nums, s, mid - 1, target);
    }

    private int findLast(int[] nums, int s, int t, int target) {
        if (s > t) {
            return -1;
        }

        int mid = (t + s) >> 1;
        if (nums[mid] < target) {
            return findLast(nums, mid + 1, t, target);
        } else if (nums[mid] > target) {
            return findLast(nums, s, mid - 1, target);
        }

        if (mid == nums.length - 1) {
            return nums.length - 1;
        }

        if (nums[mid] != nums[mid + 1]) {
            return mid;
        }

        return findLast(nums, mid + 1, t, target);
    }
}
// @lc code=end