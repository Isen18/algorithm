/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode list2 = slow.next;
        slow.next = null;

        list2 = reverse(list2);
        ListNode res = merge(head, list2);
        head.val = res.val;
        head.next = res.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = null;
        ListNode p2 = head;
        while (p2 != null) {
            ListNode p3 = p2.next;
            p2.next = p;
            p = p2;
            p2 = p3;
        }

        return p;
    }

    private ListNode merge(ListNode list, ListNode list2) {
        if (list == null) {
            return list2;
        }

        if (list2 == null) {
            return list;
        }

        ListNode dumy = new ListNode();
        ListNode p = list;
        ListNode p2 = list2;
        ListNode p3 = dumy;
        while (p2 != null) {
            p3.next = p;
            p3 = p;
            p = p.next;

            p3.next = p2;
            p3 = p2;
            p2 = p2.next;
        }

        if (p != null) {
            p3.next = p;
        }
        
        return dumy.next;
    }
}
// @lc code=end

