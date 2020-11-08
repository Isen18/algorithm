import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
      if (nums == null) {
        return null;
      }
      Map<Integer, Integer> map = new HashMap<>(nums.length);
      for (int i = 0; i < nums.length; i++) {
        Integer idx = map.get(nums[i]);
        if (idx != null && idx != i) {
          return new int[]{i, idx};
        }
        map.put(target - nums[i], i);
      }

      return null;
    }
}
// @lc code=end

