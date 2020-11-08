/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
      int s = 0;
      int t = height.length - 1;
      int res = 0;
      int minIdx;
      int tmpRes;
      while(s < t) {
        minIdx = height[s] < height[t] ? s : t;
        tmpRes = height[minIdx] * (t - s);
        if (res < tmpRes) {
          res = tmpRes;
        }
        if (minIdx == s) {
          while (s < t && height[s + 1] < height[s]) {
              s++;
          }
          if (minIdx == s) {
              s++;
          }
        } else {
            while (s < t && height[t - 1] < height[t]) {
                t--;
            }
            if (minIdx == t) {
                t--;
            }
        }
      }

      return res;
    }
}
// @lc code=end

