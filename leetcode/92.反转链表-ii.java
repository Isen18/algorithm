/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }

        ListNode p = null;
        ListNode p2 = head;
        ListNode p3 = null;
        ListNode pre = null;
        for (int i = 0; i < m; i++) {
            pre = p;
            p = p2;
            p2 = p2.next;
        }
        
        ListNode tail = p;
        for (int i = 0; i < n - m; i++) {
            p3 = p2.next;
            p2.next = p;
            p = p2;
            p2 = p3;
        }

        tail.next = p2;
        if (pre != null) {
            pre.next = p;
            return head;
        }

        return p;

    }
}
// @lc code=end