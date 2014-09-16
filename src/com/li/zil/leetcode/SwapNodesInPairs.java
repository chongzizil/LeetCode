package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/7/29.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode node;
        if (head == null || head.next == null) { return head; }

        ListNode tmpNode = head.next;
        head.next = tmpNode.next;
        tmpNode.next = head;

        head = tmpNode;
        node = head.next;

        while(node.next != null) {
            if (node.next.next != null) {
                node.next = swap(node.next, node.next.next);
                node = node.next.next;
            } else {
                node = node.next;
            }
        }

        return head;
    }

    public ListNode swap(ListNode node1, ListNode node2) {
        node1.next = node2.next;
        node2.next = node1;
        return node2;
    }

    // One very concise and clever solution, which save the codes for checking special cases of the head node.
    public ListNode swapPairs2(ListNode head) {
        ListNode start = new ListNode(0);
        start.next = head;

        for (ListNode curr = start; curr.next != null && curr.next.next != null; curr = curr.next.next) {
            curr.next = swap(curr.next, curr.next.next);
        }

        return start.next;
    }

    public ListNode swap2(ListNode node1, ListNode node2) {
        node1.next = node2.next;
        node2.next = node1;
        return node2;
    }
}
