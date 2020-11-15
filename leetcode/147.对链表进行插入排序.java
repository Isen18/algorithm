/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head.next;
        ListNode tail = head;
        while (cur != null) {
            ListNode p = dummy;
            while (p != tail && cur.val > p.next.val) {
                p = p.next;
            }

            if (p == tail) {
                tail = cur;
                cur = cur.next;
                continue;
            }

            tail.next = cur.next;
            cur.next = p.next;
            p.next = cur;

            cur = tail.next;
        }

        return dummy.next;
    }
}
// @lc code=end