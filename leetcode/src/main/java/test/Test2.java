package test;

public class Test2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
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

    public static void main(String[] args) {
        // 4,2,1,3
        ListNode node = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;

        node = new Test2().insertionSortList(node);
        System.out.println(node);
    }
}