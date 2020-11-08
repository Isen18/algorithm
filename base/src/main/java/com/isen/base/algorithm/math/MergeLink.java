package com.isen.base.algorithm.math;

/**
 * 合并链表
 *
 * @author Isen
 * @date 2020/5/25 19:49
 * @since 1.0
 */
public class MergeLink {
    static class Node {
        int value;

        Node next;

        Node(Node next) {
            this.next = next;
        }
    }

    /**
     * 合并k个有序链表
     *
     * @param links 有序链表数组
     * @return 合并后的额有序链表
     */
    public static Node mergeLinks(Node[] links) {
        return partition(links, 0, links.length);
    }

    public static Node partition(Node[] links, int start, int end) {
        if (start == end) {
            return links[start];
        }

        if (start < end) {
            int mid = start + end;
            Node l = partition(links, start, mid);
            Node l2 = partition(links, mid + 1, end);
            return mergeRec(l, l2 );
        }

        return null;
    }

    /**
     * 合并两个有序列表
     *
     * @param l 有序链表1
     * @param l2 有序链表2
     * @return 合并后的有序链表
     */
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

}
