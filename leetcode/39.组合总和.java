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
        // doCombinationSum(candidates, target, tmp);
        // doCombinationSum2(candidates, target, 0, tmp);

        doCombinationSum3(candidates, target, 0, tmp);
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

    private void doCombinationSum2(int[] candidates, int target, int k, List<Integer> tmp) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        if (target < 0) {
            return;
        }
        
        for (int i = k; i < candidates.length; i++) {
            if (candidates[i] > target) {
                //>i的值都大于target
                return;
            }

            // if (!tmp.isEmpty() && candidates[i] < tmp.get(tmp.size() - 1)) {
            //     //出现逆序对，则重复
            //     continue;
            // }

            tmp.add(candidates[i]);
            doCombinationSum2(candidates, target - candidates[i], i, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    private void doCombinationSum3(int[] candidates, int target, int k, List<Integer> tmp) {
        if (target == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        if (target < 0) {
            return;
        }

        if (k >= candidates.length) {
            return;
        }
        
        if (candidates[k] > target) {
            //>k的值都大于target
            return;
        }

        tmp.add(candidates[k]);
        doCombinationSum3(candidates, target - candidates[k], k, tmp);
        tmp.remove(tmp.size() - 1);

        doCombinationSum3(candidates, target, k + 1, tmp);
    }
}
// @lc code=end