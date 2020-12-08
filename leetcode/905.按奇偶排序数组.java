/*
 * @lc app=leetcode.cn id=905 lang=java
 *
 * [905] 按奇偶排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int s = 0;
        int t = res.length - 1;
        for (int i = 0; i < A.length; i++) {
            if ((A[i] & 1) == 0) {
                res[s++] = A[i];
            } else {
                res[t--] = A[i];
            }
        }

        return res;
    }
}
// @lc code=end