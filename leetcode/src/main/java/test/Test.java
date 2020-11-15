package test;

public class Test {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
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

  public static void main(String[] args) {
    Test test = new Test();
    int[] nums1 = {1, 2};
    int[] nums2 = {3, 4};
    double midNum = test.findMedianSortedArrays(nums1, nums2);
    System.out.println(midNum);
  }
}