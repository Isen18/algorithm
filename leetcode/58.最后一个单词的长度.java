/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int q = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (q > -1) {
                    return q - i;
                }

                continue;
            }

            if (q == -1) {
                q = i;
            }
        }

        if (q > -1) {
            return q + 1;
        }

        return 0;
    }
}
// @lc code=end