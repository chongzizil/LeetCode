package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/7/14.
 */
public class LinkedListCycle {

    // A O(n) solution which use constant space.  Floyd's algorithm for cycle detection.
    public ListNode detectCycle(ListNode head) {
        ListNode fastNode;
        ListNode slowNode;

        if (head == null) { return null; }
        fastNode = new ListNode(head.val);
        slowNode = new ListNode(head.val);
        fastNode.next = head.next;
        slowNode.next = head.next;

        while(slowNode.next != null && fastNode.next != null && fastNode.next.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode) {
                slowNode = head;
                while (slowNode != fastNode) {
                    slowNode = slowNode.next;
                    fastNode = fastNode.next;
                }

                return slowNode;
            }
        }

        return null;
    }
}
