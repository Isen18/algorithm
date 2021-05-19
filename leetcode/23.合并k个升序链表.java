/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
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
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }

    private ListNode partition(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }

        if (start < end) {
            int mid = (start + end) >> 1;
            ListNode l = partition(lists, start, mid);
            ListNode l2 = partition(lists, mid + 1, end);            
            return merge(l, l2);
        }

        return null;
    }     

    private ListNode merge(ListNode l, ListNode l2) {
        if(l == null) {
            return l2;
        }

        if (l2 == null) {
            return l;
        }

        if (l.val < l2.val) {
            l.next = merge(l.next, l2);
            return l;
        }

        l2.next = merge(l2.next, l);
        return l2;
    }
}
// @lc code=end

