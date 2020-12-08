import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {

    private void quickSort(int[][] intervals, int s, int t) {
        if (intervals == null || intervals.length == 0 || s >= t) {
            return;
        }

        int i = s;
        int j = t;
        int[] base = intervals[i];
        while (i < j) {
            while (i < j && intervals[j][0] >= base[0]) {
                j--;
            }
            intervals[i] = intervals[j];

            while (i < j && intervals[i][0] < base[0]) {
                i++;
            }
            intervals[j] = intervals[i];
        }
        intervals[i] = base;

        quickSort(intervals, s, i);
        quickSort(intervals, i + 1, t);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        quickSort(intervals, 0, intervals.length - 1);

        int i = 0;
        int j = 1;
        while (j < intervals.length) {
            if (intervals[i][1] < intervals[j][0]) {
                intervals[i + 1] = intervals[j];
                i++;
                j++;
                continue;
            }

            if (intervals[i][1] < intervals[j][1]) {
                intervals[i][1] = intervals[j][1];
            }
            j++;
        }

        int[][] res = new int[i + 1][2];
        for (j = 0; j <= i; j++) {
            res[j] = intervals[j];
        }

        return res;
    }
}
// @lc code=end