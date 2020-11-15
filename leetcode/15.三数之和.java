import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = nums.length - 1;
            for (int j = i + 1; j < k;) {
                int sumIJ = nums[i] + nums[j];
                while (k > j) {
                    int sumIJK = sumIJ + nums[k];
                    if (sumIJK == 0) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        break;
                    }

                    if (sumIJK < 0) {
                        break;
                    }
                    k--;  
                }

                while (++j < k && nums[j] == nums[j - 1]) {}
            }
        }

        return res;
    }
}
// @lc code=end