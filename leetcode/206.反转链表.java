/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
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

    /**
     * 循环
     */
    public ListNode reverseList0(ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }

      ListNode p = head;
      ListNode p2 = p.next;
      ListNode p3;
      p.next = null;
      while (p2 != null) {
        p3 = p2.next;
        p2.next = p;
        p = p2;
        p2 = p3;
      }

      return p;
    }

    public ListNode reverseList(ListNode head) {
      ListNode p = null;
      ListNode p2 = head;
      ListNode p3;
      while (p2 != null) {
        p3 = p2.next;
        p2.next = p;
        p = p2;
        p2 = p3;
      }

      return p;
    }

    /**
     * 递归
     */
    // public ListNode reverseList(ListNode head) {
    //   if (head == null || head.next == null) {
    //     return head;
    //   }

    //   ListNode res = reverseList(head.next);
    //   head.next.next = head;
    //   head.next = null;
    //   return res;
    // }
}
// @lc code=end

