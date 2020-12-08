import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 */

// @lc code=start
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 1; i <= nums.length; i++) {
            doCombine(nums, 0, i, new ArrayList<>(i));
        }

        return res;
    }

    private void doCombine(int nums[], int i, int k, List<Integer> tmp) {
        if (k == 0) {
            res.add(new ArrayList<>(tmp)); 
            return;
        }

        if (i >= nums.length) {
            return;
        }

        tmp.add(nums[i]);
        doCombine(nums, i + 1, k - 1, tmp);
        tmp.remove(tmp.size() - 1);

        doCombine(nums, i + 1, k, tmp);
    }
}
// @lc code=end