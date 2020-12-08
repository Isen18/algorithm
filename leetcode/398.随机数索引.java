import java.util.Random;

/*
 * @lc app=leetcode.cn id=398 lang=java
 *
 * [398] 随机数索引
 */

// @lc code=start
class Solution {
    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    public int pick(int target) {
        int ans = -1;
        int cur = 1;
        Random random = new Random();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (random.nextInt(cur++) == 0) {
                    ans = i;
                }
            }
        }

        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
// @lc code=end