package com.isen.base.algorithm.sort;

/**
 * @author Isen
 * @date 2020/5/25 19:25
 * @since 1.0
 */
public class LinkSort {

    static class Node {
        int value;

        Node next;

        Node(Node next) {
            this.next = next;
        }
    }

    public static Node sort(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node p = node;
        Node p2 = node;
        Node pre = node;
        while(p2 != null && p2.next != null) {
            pre = p;
            p = p.next;
            p2 = p2.next.next;
        }

        pre.next = null;

        return merge(sort(node), sort(p));

    }

    public static Node merge(Node l, Node l2) {
        Node dummyNode = new Node(null);
        Node cur = dummyNode;
        while(l != null && l2 != null) {
            if (l.value <= l2.value) {
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

    public static Node mergeRec(Node l, Node l2) {
        if (l == null) {
            return l2;
        }

        if (l2 == null) {
            return l;
        }

        if (l.value <= l2.value) {
            l.next = mergeRec(l.next, l2);
            return l;
        } else {
            l2.next = mergeRec(l, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {

    }
}
