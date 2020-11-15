/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        int len = 0;
        for (int i = 0; i < k ; i++) {
            p = p.next;
            if (p == null) {
                len = i + 1;
                break;
            }
        }

        if (len > 0) {
            k = k % len;
        }

        if (k == 0) {
            return head;
        }

        p = head;
        for (int i = 0; i < k ; i++) {
            p = p.next;
        }

        ListNode tail = head;
        while (p.next != null) {
            p = p.next;
            tail = tail.next;
        }

        ListNode res = tail.next;
        tail.next = null;
        p.next = head;
        return res;
    }
}
// @lc code=end