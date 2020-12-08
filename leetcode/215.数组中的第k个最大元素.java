/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */

// @lc code=start
class Solution {
    /**
     * 快速排序的划分
     */
    public int findKthLargest(int[] nums, int k) {
        int targetIdx = nums.length - k;
        int idx = idxOf(nums, 0, nums.length - 1);
        while (idx != targetIdx) {
            if (idx < targetIdx) {
                idx = idxOf(nums, idx + 1, nums.length - 1);
            } else {
                idx = idxOf(nums, 0, idx - 1);
            }
        }

        return nums[idx];
    }

    private int idxOf(int[] nums, int s, int t) {
        int base = nums[s];
        while (s < t) {
            while (s < t && nums[t] >= base) {
                t--;
            }
            nums[s] = nums[t];
            while (s < t && nums[s] <= base) {
                s++;
            }
            nums[t] = nums[s];
        }

        nums[s] = base;
        return s;
    }

    // /**
    //  * 堆排序
    //  */
    // public int findKthLargest(int[] nums, int k) {
    //     int[] tmpNums = new int[nums.length + 1];
    //     for (int i = 0; i < nums.length; i++) {
    //         tmpNums[i + 1] = nums[i];
    //     }

    //     int end = tmpNums.length - 1;
    //     for (int i = end >> 1; i > 0 ; i--) {
    //         shift(tmpNums, i, end);
    //     }

    //     for (int i = 0, j = end; i < k - 1; i++) {
    //         int tmp = tmpNums[1];
    //         tmpNums[1] = tmpNums[j];
    //         tmpNums[j] = tmp;
    //         shift(tmpNums, 1, j - 1);
    //     }

    //     return tmpNums[1];
    // }

    // //包含s和t
    // private void shift(int[] array, int k, int end) {
    //     int i = k;
    //     int j = i << 1;
    //     int tmp = array[k];
    //     while(j <= end){
    //         //j 指向最大的孩子
    //         if(j < end && array[j] < array[j + 1]){
    //             j++;
    //         }

    //         if(array[j] > tmp){
    //             array[i] = array[j];
    //             i = j;
    //             j = i << 1;
    //         }else {
    //             break;
    //         }
    //     }

    //     array[i] = tmp;
    // }
}
// @lc code=end