package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test3 {
    
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int tmp = 0;
        while (x > 0) {
            int a = x % 10;
            tmp = tmp * 10 + a;
            x = x / 10;
        }

        return x == tmp;
    }

    public static void main(String[] args) {
        Test3 test3 = new Test3();
        boolean res = test3.isPalindrome(121);
        System.out.println(res);
    }
}