import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    boolean[] vis;
    List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        vis = new boolean[nums.length];
        res = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<>(nums.length);
        doPermuteUnique(nums, 0, tmp);
        return res;
    }
    
    private void doPermuteUnique(int[] nums, int k, List<Integer> tmp) {
        if (k == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) {
                continue;
            }

            //例1：1,1,2
            //例2：1,1,2,2 第1个2可以和第1个1交换，但是第1个2不能和第1个1交换，否则重复
            // 要解决重复问题，我们只要设定一个规则，保证在填第 k个数的时候重复数字只会被填入一次即可。
            // 而在本题解中，我们选择对原数组排序，保证相同的数字都相邻，然后每次填入的数一定是这个数所在重复数集合中「从左往右第一个未被填过的数字」，即如下的判断条件：
            if (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1]) {
                continue;
            }

            vis[i] = true;
            tmp.add(nums[i]);
            doPermuteUnique(nums, k + 1, tmp);
            tmp.remove(k);
            vis[i] = false;
        }
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