/*
 * @lc app=leetcode.cn id=457 lang=java
 *
 * [457] 环形数组循环
 */

// @lc code=start
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        //正(负)数相加 == nums.length 并且个数 > 2
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            boolean flag = nums[i] > 0 ? true : false;
            int sum = nums[i];
            int k = 1;
            int j = i;
            while (true) {
                j = (j + nums[j]) % n;
                if (j < 0) {
                    j += n;
                }

                if (flag && nums[j] < 0) {
                    //不同时 > 0
                    break;
                } else if (!flag && nums[j] > 0) {
                    //不同时 < 0
                    break;
                }

                sum += nums[j];
                if (sum > n || sum < -n) {
                    break;
                }

                if (j != i) {
                    k++;
                }

                if ((sum % n  == 0 || -sum % n == 0) && k > 1) {
                    //至少两个不同位置数相加 = n
                    return true;
                }
            }
        }

        return false;
    }
}
// @lc code=end