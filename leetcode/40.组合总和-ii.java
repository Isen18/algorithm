/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
       //为了保证选取没有出现逆序，若出现逆序则为重复
       Arrays.sort(candidates);
       res = new ArrayList<>();
       List<Integer> tmp = new ArrayList<>();
       boolean[] vis = new boolean[candidates.length];
    //    doCombinationSum(candidates, target, vis, tmp);
       doCombinationSum2(candidates, target, 0, vis, tmp);
       return res;
   }

   private void doCombinationSum(int[] candidates, int target, boolean[] vis, List<Integer> tmp) {
       if (target == 0) {
           res.add(new ArrayList<>(tmp));
           return;
       }

       if (target < 0) {
           return;
       }
       
       for (int i = 0; i < candidates.length; i++) {
            if (vis[i]) {
                //访问过
                continue;
            }

            //1, 1, 2
            //防止出现[1, 2]和[1, 2]重复
            if (i > 0 && candidates[i] == candidates[i - 1] && !vis[i - 1]) {
                //相同值，且不是第一个未访问的值
                continue;
            }

           if (candidates[i] > target) {
               //>i的值都大于target
               return;
           }

           //1, 1, 2
            //防止出现[1, 2]和[2, 1]逆序
           if (!tmp.isEmpty() && candidates[i] < tmp.get(tmp.size() - 1)) {
               //出现逆序对，则重复
               continue;
           }

           vis[i] = true;
           tmp.add(candidates[i]);
           doCombinationSum(candidates, target - candidates[i], vis, tmp);
           tmp.remove(tmp.size() - 1);
           vis[i] = false;
       }
   }

   private void doCombinationSum2(int[] candidates, int target, int k, boolean[] vis, List<Integer> tmp) {
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
            return;
        }

        //1, 1, 2
        //防止出现[1, 2]和[1, 2]重复
        if (k > 0 && candidates[k] == candidates[k - 1] && !vis[k - 1]) {
            //相同值，且不是第一个未访问的值
            doCombinationSum2(candidates, target, k + 1, vis, tmp);
            return;
        }

        vis[k] = true;
        tmp.add(candidates[k]);
        doCombinationSum2(candidates, target - candidates[k], k + 1, vis, tmp);
        tmp.remove(tmp.size() - 1);
        vis[k] = false;

        doCombinationSum2(candidates, target, k + 1, vis, tmp);
    }
}
// @lc code=end