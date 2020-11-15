/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        for (int k = 0; k < strs[0].length(); k++) {
            char c = strs[0].charAt(k);
            for (int i = 1; i < strs.length; i++) {
                if (k >= strs[i].length() || strs[i].charAt(k) != c) {
                    return strs[0].substring(0, k);
                }
            }
        }

        return strs[0];
    }
}
// @lc code=end