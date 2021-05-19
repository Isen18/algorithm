/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide0(int dividend, int divisor) {
        int ans = 0;
        boolean isPos = true;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) {
            isPos = false;
        }

        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            //溢出
            return Integer.MAX_VALUE;
        }

        //全部转为负数加法
        if (dividend > 0) {
            dividend = -dividend;
        }

        if (divisor > 0) {
            divisor = -divisor;
        }

        while (dividend <= divisor) {
            dividend -= divisor;
            ans++;
        }
        
        return isPos ? ans : -ans;
    }

    public int divide(int dividend, int divisor) {
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            //溢出
            return Integer.MAX_VALUE;
        }

        boolean isPos = true;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0){
            isPos = false;
        }

        //全部转为负数
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;
        if (a > b) {
            return 0;
        }

        if (b == -1) {
            return isPos ? -a : a;
        }

        int ans = 1;
        int oldB = b;
        while (true) {
            while (a < b) {
                b <<= 1;
                ans <<= 1;
            }

            if (a == b) {
                break;
            }

            if (a > b) {
                a -= b >> 1;
                ans >>= 1;
                b = oldB;
            } 

            if (a > b) {
                break;
            }

            if (a - b > b) {
                ans++;
                break;
            }
        }
        
        return isPos ? ans : -ans;
    }
}
// @lc code=end

