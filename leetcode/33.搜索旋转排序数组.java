/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int len = nums.length;
        int maxIdx = findMaxIdx(nums, 0, len - 1);
        if (target >= nums[0]) {
            return binarySarch(nums, 0, maxIdx, target);
        }

        return binarySarch(nums, maxIdx + 1, len - 1, target);
    }

    private int binarySarch(int[] nums, int s, int t, int target) {
        while (s <= t) {
            int mid = (s + t) >> 1;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                s = mid + 1;
            } else {
                t = mid - 1;
            }
        }

        return -1;
    }

    private int findMaxIdx(int[] nums, int s, int t) {
        int i = s;
        int j = t;

        if (i == j) {
            return i;
        }

        if (nums[i] < nums[j]) {
            return j;
        }

        while (i < j) {
            int mid = (i + j) >> 1;
            if (mid < t && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid] > nums[t]) {
                i = mid;
            } else {
                j = mid;
            }
        }

        return -1;
    }
}
// @lc code=end

