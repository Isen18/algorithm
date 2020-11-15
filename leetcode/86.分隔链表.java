/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode p = dummy;
        ListNode p2 = dummy2;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                p.next = cur;
                p = p.next;
            } else {
                p2.next = cur;
                p2 = p2.next;
            }
            cur = cur.next;
        }

        p2.next = null;
        p.next = dummy2.next;
        return dummy.next;
    }
}
// @lc code=end