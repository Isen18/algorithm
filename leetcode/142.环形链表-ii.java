/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        int slowLen = 1;
        int fastLen = 2;
        while (fast != null) {
            if (fast == slow) {
                break;
            }

            fast = fast.next;
            if (fast == null) {
                break;
            }

            fast = fast.next;
            slow = slow.next;
            fastLen += 2;
            slowLen++;
        }

        if (fast == null) {
            //不存在环
            return null;
        }

        //环的长度
        int len = fastLen - slowLen;
        fast = head;
        for (int i = 0; i < len; i++) {
            fast = fast.next;
        }

        slow = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
// @lc code=end