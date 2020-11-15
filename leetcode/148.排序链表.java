/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }

        return doSortList(head, len);

        // return sort(head);
    }

    private ListNode doSortList(ListNode head, int len) {
        if (len <= 1) {
            return head;
        }

        if (len == 2) {
            ListNode p = head.next;
            head.next = null;
            return mergerList(head, p);
        }

        int mid = len >> 1;
        ListNode p = head;
        for (int i = 1; i < mid; i++) {
            p = p.next;
        }
        ListNode p2 = p.next;
        p.next = null;

        ListNode l1 = doSortList(head, mid);
        ListNode l2 = doSortList(p2, len - mid);
        return mergerList(l1, l2);
    }

    private ListNode mergerList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {
            p.next = l1;
        }

        if (l2 != null) {
            p.next = l2;
        }

        return dummy.next;
    }

    public ListNode sort(ListNode ListNode) {
        if (ListNode == null || ListNode.next == null) {
            return ListNode;
        }

        ListNode p = ListNode;
        ListNode p2 = ListNode;
        ListNode pre = ListNode;
        while(p2 != null && p2.next != null) {
            pre = p;
            p = p.next;
            p2 = p2.next.next;
        }

        pre.next = null;

        return merge(sort(ListNode), sort(p));

    }

    public ListNode merge(ListNode l, ListNode l2) {
        ListNode dummyNode = new ListNode();
        ListNode cur = dummyNode;
        while(l != null && l2 != null) {
            if (l.val <= l2.val) {
                cur.next = l;
                l = l.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }

            cur = cur.next;
        }

        if (l != null) {
            cur.next = l;
        }

        if (l2 != null) {
            cur.next = l2;
        }

        cur = dummyNode.next;
        dummyNode.next = null;
        return cur;
    }

    public ListNode mergeRec(ListNode l, ListNode l2) {
        if (l == null) {
            return l2;
        }

        if (l2 == null) {
            return l;
        }

        if (l.val <= l2.val) {
            l.next = mergeRec(l.next, l2);
            return l;
        } else {
            l2.next = mergeRec(l, l2.next);
            return l2;
        }
    }
}
// @lc code=end