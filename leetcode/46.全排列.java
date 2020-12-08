import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        doPermute(nums, 0, res);
        return res;
    }

    private void doPermute(int[] nums, int k, List<List<Integer>> res) {
        if (k == nums.length) {
            res.add(of(nums));
            return;
        }

        for (int i = k; i < nums.length; i++) {
            swap(nums, k, i);
            doPermute(nums, k + 1, res);
            swap(nums, k, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private List<Integer> of(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);
        for (int tmp: nums) {
            res.add(tmp);
        }

        return res;
    }
}
// @lc code=end