import java.util.Random;

/*
 * @lc app=leetcode.cn id=382 lang=java
 *
 * [382] 链表随机节点
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
    private int len = 0;
    private Random random;
    private ListNode head;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        while (head != null) {
            len++;
            head = head.next;
        }

        random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int ans = head.val;
        ListNode p = head.next;
        int i = 2;
        Random random = new Random();
        while (p != null) {
            if (random.nextInt(i) == 0) {
                ans = p.val;
            }
            i++;
            p = p.next;
        }

        return ans;
    }

    // public int getRandom() {
    //     int k = random.nextInt(len);
    //     ListNode p = this.head;
    //     while (k-- > 0) {
    //         p = p.next;
    //     }

    //     return p.val;
    // }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
// @lc code=end