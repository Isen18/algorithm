import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 递增子序列
 */

// @lc code=start
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(nums[i]);
            doFindSubsequences(nums, i, tmp);
        }
        return res;
    }

    public void doFindSubsequences(int[] nums, int idx, List<Integer> tmp) {
        if (idx >= nums.length - 1) {
            return;
        }

        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = idx + 1; i < nums.length; i++) {
            if (nums[i] < tmp.get(tmp.size() - 1)) {
                continue;
            }

            if (set.contains(nums[i])) {
                continue;
            }

            //选择
            set.add(nums[i]);
            tmp.add(nums[i]);
            if (tmp.size() > 1) {
                res.add(new ArrayList<>(tmp));
            }
            doFindSubsequences(nums, i, tmp);
            tmp.remove(tmp.size() - 1);

            //不选择
        }
    }
}
// @lc code=end