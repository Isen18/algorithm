package test;

import java.util.*;

public class Test4 {

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

        if (vis[k]) {
            //访问过
            doCombinationSum2(candidates, target, k + 1, vis, tmp);
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
    }

    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        new Test4().combinationSum2(arr, 8);
    }
    
}
