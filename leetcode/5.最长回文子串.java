/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
class Solution {
    // 中心扩散算法O(n^2)
    public String longestPalindrome0(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int len = s.length();
        int maxLen = 0;
        int maxLeft = 0;
        for (int cur = 0; cur < len; cur++) {
            int tmpLen = 1;
            int left = cur - 1;
            int right = cur + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(cur)) {
                left--;
                tmpLen++;
            }
            while (right < len && s.charAt(right) == s.charAt(cur)) {
                right++;
                tmpLen++;
            }
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                tmpLen += 2;
            }

            if (tmpLen > maxLen) {
                maxLen = tmpLen;
                maxLeft = left;
            }
        }

        return s.substring(maxLeft + 1, maxLeft + 1 + maxLen);
    }

    // 动态规划O(n^2)
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLeft = 0;
        int maxLen = 0;
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > maxLen) {
                    maxLeft = i;
                    maxLen = l + 1;
                }
            }
        }
        return s.substring(maxLeft, maxLeft + maxLen);
    }
}
// @lc code=end
