/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummy = new ListNode(0);
      ListNode p = dummy;
      int ex = 0;
      while (l1 != null || l2 != null || ex != 0) {
        int a = l1 == null ? 0 : l1.val;
        int b = l2 == null ? 0 : l2.val;
        int c = a + b + ex;
        if (c > 9) {
          c -= 10;
          ex = 1;
        } else {
          ex = 0;
        }
        p.next = new ListNode(c);
        p = p.next;
        if (l1 != null) {
          l1 = l1.next;
        }
        if (l2 != null) {
          l2 = l2.next;
        }
      }

      return dummy.next;
    }
}
// @lc code=end
