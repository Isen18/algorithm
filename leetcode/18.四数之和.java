import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int r = nums.length - 1;
                for (int k = j + 1; k < r; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1]) {
                        continue;
                    }

                    for (; r > k; r--) {
                        int sum = nums[i] + nums[j] + nums[k] + nums[r];
                        if (sum == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[r]));
                            break;
                        }
    
                        if (sum < target) {
                            break;
                        }
                    }
                }
            }
        }

        return res;
    }
}
// @lc code=end