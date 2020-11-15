/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy;
        ListNode p2 = p.next;
        ListNode p3;
        while (p2 != null && p2.next != null) {
            p3 = p2.next;
            p2.next = p3.next;
            p3.next = p2;
            p.next = p3;

            p = p2;
            p2 = p2.next;
        }

        ListNode res = dummy.next;
        dummy.next = null;
        return res;
    }
}
// @lc code=end