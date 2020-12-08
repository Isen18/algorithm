import java.util.Set;

/*
 * @lc app=leetcode.cn id=137 lang=java
 *
 * [137] 只出现一次的数字 II
 */

// @lc code=start
class Solution {
    // public int singleNumber(int[] nums) {
    //     Set<Integer> set = new HashSet<>();
    //     long sum = 0;
    //     long sum2 = 0;
    //     for (int a : nums) {
    //         sum += a;
    //         set.add(a);
    //     }

    //     for (int a : set) {
    //         sum2 += a;
    //     }

    //     int ans = (int)((3 * sum2 - sum) / 2);
    //     return ans;
    // }

    public int singleNumber(int[] nums) {
        int mask = 1;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++){
                if ((nums[j] & mask) != 0) {
                    count++;
                }
            }

            if (count % 3 != 0) {
                ans |= mask;
            }

            mask <<= 1;
        }

        return ans;
    }
    
}
// @lc code=end