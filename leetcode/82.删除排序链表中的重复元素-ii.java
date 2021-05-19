/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dumy = new ListNode(0, head);
        //tail链接无重复的节点
        ListNode tail = dumy;
        ListNode p = head;
        //判断p是否重复
        boolean pDuplicate = false;
        while (p.next != null) {
            if (!pDuplicate && p.val != p.next.val) {
                tail.next = p;
                tail = p;
            } else if (p.val == p.next.val) {
                //重复
                pDuplicate = true;
            } else {
                pDuplicate = false;
            }
        
            p = p.next;
        }

        if (!pDuplicate) {
            tail.next = p;
        } else {
            tail.next = null;
        }

        ListNode res = dumy.next;
        dumy.next = null;
        return res;
    }
}
// @lc code=end

