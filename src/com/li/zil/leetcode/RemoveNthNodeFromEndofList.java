package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/8/9.
 */
public class RemoveNthNodeFromEndofList {
	// Dummy node is really handy = .=
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummyHead = new ListNode(0);
		ListNode fastNode = dummyHead;
		ListNode slowNode = dummyHead;

		dummyHead.next = head;

		if (dummyHead.next == null) { return null; }

		for (int i = 0; i < n; i++) {
			fastNode = fastNode.next;
		}

		while (fastNode.next != null) {
			fastNode = fastNode.next;
			slowNode = slowNode.next;
		}

		slowNode.next = slowNode.next.next;

		return dummyHead.next;
	}
}
