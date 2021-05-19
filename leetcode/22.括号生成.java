import java.util.List;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        doGenerateParenthesis(n, n, "");

        // dfs(n, n, "");

        return res;
    }

    private void doGenerateParenthesis(int leftN, int rightN, String str) {
        if (leftN == 0 && rightN == 0) {
            res.add(str);
            return;   
        }

        if (leftN == rightN) {
            doGenerateParenthesis(leftN - 1, rightN, str + "(");
            return;
        }

        if (leftN == 0) {
            doGenerateParenthesis(leftN, rightN - 1, str + ")");
            return;
        }

        if (leftN > 0) {
            doGenerateParenthesis(leftN - 1, rightN, str + "(");
        }

        if (rightN > 0) {
            doGenerateParenthesis(leftN, rightN - 1, str + ")");
        }
    }

    private void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) { // 左右括号都不剩余了，递归终止
            res.add(curStr);
            return;
        }

        if (left > 0) { // 如果左括号还剩余的话，可以拼接左括号
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left) { // 如果右括号剩余多于左括号剩余的话，可以拼接右括号
            dfs(left, right - 1, curStr + ")");
        }
    }
}
// @lc code=end

