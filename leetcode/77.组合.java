import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    List<List<Integer>> res;

    //还有一种方法k个1从左移动到右，循环+回溯

    
    public List<List<Integer>> combine(int n, int k) {
        int nums[] = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        res = new ArrayList<>();
        doCombine(nums, 0, k, new ArrayList<>(k));
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