/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {

    public double myPow(double x, int n) {
        if (x == 0 && n == 0) {
            throw new RuntimeException("无效输入 x=0, n=0");
        }

        if (x == 0 && n < 0) {
            throw new RuntimeException("无效输入 x=0, n<0");
        }
        
        long tmpN = n;
        if (tmpN < 0) {
            tmpN = -tmpN;
        }
        double res = doMyPow(x, tmpN);
        if (n < 0) {
            return 1 / res;
        }
    
        return res;
    }


    private double doMyPow(double x, long n) {
        if (n == 0) {
            return 1.;
        }

        long mid = n >> 1;
        double res = doMyPow(x, mid);
        res *= res;
        if ((n & 1) == 1) {
            res *= x;
        }

        return res;
    }
}
// @lc code=end