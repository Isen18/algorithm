/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[cur--] = nums1[i--];
            } else {
                nums1[cur--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[cur--] = nums2[j--];
        }
    }
}
// @lc code=end