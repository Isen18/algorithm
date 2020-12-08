import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //为了保证选取没有出现逆序，若出现逆序则为重复
        Arrays.sort(candidates);
        res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        doCombinationSum(candidates, target, tmp);
        return res;
    }

    private void doCombinationSum(int[] candidates, int target, List<Integer> tmp) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        if (target < 0) {
            return;
        }
        
        for (int i = 0; i < candidates.length; i++) {
            if (candidates[i] > target) {
                //>i的值都大于target
                return;
            }

            if (!tmp.isEmpty() && candidates[i] < tmp.get(tmp.size() - 1)) {
                //出现逆序对，则重复
                continue;
            }

            tmp.add(candidates[i]);
            doCombinationSum(candidates, target - candidates[i], tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
// @lc code=end