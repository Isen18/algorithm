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
    public ListNode reverseBetween0(ListNode head, int m, int n) {
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

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null || head.next == null) {
            return head;
        }

        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode p = dumy;
        for (int i = 0; i < m - 1; i++) {
            p = p.next;
        }

        ListNode tail = p;
        ListNode p2 = p.next;
        ListNode p3 = null;
        for (int i = 0; i <= n - m; i++) {
            p3 = p2.next;
            p2.next = p;
            p = p2;
            p2 = p3;
        }

        tail.next.next = p2;
        tail.next = p;
        return dumy.next;
    }

}
// @lc code=end