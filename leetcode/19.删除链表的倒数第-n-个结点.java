/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy;
        for (int i = 0; i <= n; i++) {
            p = p.next;
        }   

        ListNode pre = dummy;
        while (p != null) {
            pre = pre.next;
            p = p.next;
        }

        p = pre.next.next;
        pre.next.next = null;
        pre.next = p;

        p = dummy.next;
        dummy.next = null;
        return p;
    }
}
// @lc code=end

