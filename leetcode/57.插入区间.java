/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>(intervals.length + 1);
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                res.add(interval);
                continue;
            }

            if (interval[0] >= newInterval[0]) {

            }

            if (interval[0] > newInterval[1]) {
                //插入点在左侧
                // res.add(interval);
                continue;
            }
        }


    }
}
// @lc code=end

