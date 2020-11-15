/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    //两个数组合并，取中间值
    public double findMedianSortedArrays0(int[] nums1, int[] nums2) {
      int totalLen = nums1.length + nums2.length;
      int[] tmpArr = new int[totalLen];
      int k = 0;
      int i = 0;
      int j = 0;
      while (i < nums1.length || j < nums2.length ) {
        if (i < nums1.length && j < nums2.length) {
          if (nums1[i] <= nums2[j]) {
            tmpArr[k++] = nums1[i++];
          } else {
            tmpArr[k++] = nums2[j++];
          }
        } else if (i < nums1.length) {
          tmpArr[k++] = nums1[i++];
        } else {
          tmpArr[k++] = nums2[j++];
        }
      }

      int idx = totalLen >> 1;
      if ((totalLen & 1) == 1) {
        //奇数
        return tmpArr[idx];
      }

      return (tmpArr[idx - 1] + tmpArr[idx]) / 2.0;
    }

    //不需要数组合并，直接找中间值
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
      int left = -1;
      int right = -1;
      int p = 0;
      int q = 0;
      int len = nums1.length + nums2.length;
      int midIdx = len >> 1;
      for (int i = 0; i <= midIdx; i++) {
        left = right;
        if (p < nums1.length && (q >= nums2.length || nums1[p] <= nums2[q])) {
          right = nums1[p++];
        } else {
          right = nums2[q++];
        }
      }

      if ((len & 1) == 1) {
        return right;
      }

      return (left + right) / 2.0;
    }

    //采用第k个值 + 二分查找
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int n = nums1.length;
      int m = nums2.length;
      int left = (n + m + 1) / 2;
      int right = (n + m + 2) / 2;
      //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
      return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;  
  }
      
  private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
      int len1 = end1 - start1 + 1;
      int len2 = end2 - start2 + 1;
      //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1 
      if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
      if (len1 == 0) return nums2[start2 + k - 1];

      if (k == 1) return Math.min(nums1[start1], nums2[start2]);

      int i = start1 + Math.min(len1, k / 2) - 1;
      int j = start2 + Math.min(len2, k / 2) - 1;

      if (nums1[i] > nums2[j]) {
          return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
      }
      else {
          return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
      }
  }

}
// @lc code=end
