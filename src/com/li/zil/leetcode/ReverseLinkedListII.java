package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/8/10.
 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;

		ListNode startNode = dummyHead;
		ListNode currNode;

		for(int i = 0; i < m - 1 ; i++) {
			startNode = startNode.next;
		}

		currNode = startNode.next;

		for(int i = 0; i < n - m; i++) {
			ListNode nextNode = currNode.next;
			ListNode firstNode = startNode.next;

			currNode.next = nextNode.next;
			nextNode.next = firstNode;
			startNode.next = nextNode;
		}

		return dummyHead.next;
	}
}
