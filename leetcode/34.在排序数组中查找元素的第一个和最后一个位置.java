/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // int first = findFirst(nums, 0, nums.length - 1, target);
        // int last = findLast(nums, 0, nums.length - 1, target);
        int first = findFirst2(nums, 0, nums.length - 1, target);
        int last = findLast2(nums, 0, nums.length - 1, target);
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

    private int findFirst2(int[] nums, int s, int t, int target) {
        while (s <= t) {
            int mid = (s + t) >> 1;
            if (nums[mid] < target) {
                s = mid + 1;
                continue;
            }

            if (nums[mid] > target) {
                t = mid - 1;
                continue;
            }

            if (mid == 0) {
                return 0;
            }

            if (nums[mid] != nums[mid - 1]) {
                return mid;
            }

            t = mid - 1;
        }

        return -1;
    }

    private int findLast2(int[] nums, int s, int t, int target) {
        while (s <= t) {
            int mid = (s + t) >> 1;
            if (nums[mid] < target) {
                s = mid + 1;
                continue;
            }

            if (nums[mid] > target) {
                t = mid - 1;
                continue;
            }

            if (mid == nums.length - 1) {
                return nums.length - 1;
            }

            if (nums[mid] != nums[mid + 1]) {
                return mid;
            }

            s = mid + 1;
        }

        return -1;
    }
}
// @lc code=end