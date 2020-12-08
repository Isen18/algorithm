/*
 * @lc app=leetcode.cn id=191 lang=java
 *
 * [191] 位1的个数
 */

// @lc code=start
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight0(int n) {
        int mask = 1;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) !=0) {
                ans++;
            }
            mask <<= 1;
        }

        return ans;
    }

    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans++;
            n &= (n - 1);
        }
        return ans;
    }
}
// @lc code=end