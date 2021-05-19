package test;

public class Test5 {

    public int divide(int dividend, int divisor) {
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            //溢出
            return Integer.MAX_VALUE;
        }

        //全部转为负数
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;
        if (a > b) {
            return 0;
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
        
        boolean isPos = true;
        if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0){
            isPos = false;
        }
        return isPos ? ans : -ans;
    }

    public static void main(String[] args) {
        new Test5().divide(2147483647, 2);
    }
    
}
