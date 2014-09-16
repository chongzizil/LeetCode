package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/7/23.
 */
public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) { return l2; }
		if (l2 == null) { return l1; }

		ListNode head = l1.val < l2.val ? l1 : l2;
		ListNode curr = head;
		ListNode nodeA = l1.val < l2.val ? l1.next : l1;
		ListNode nodeB = l1.val < l2.val ? l2 : l2.next;

		while(nodeA != null && nodeB != null) {
			if (nodeA.val < nodeB.val) {
				curr.next = nodeA;
				curr = nodeA;
				nodeA = nodeA.next;
			} else {
				curr.next = nodeB;
				curr = nodeB;
				nodeB = nodeB.next;
			}
		}

		if (nodeA == null) { curr.next = nodeB; }
		if (nodeB == null) { curr.next = nodeA; }

		return head;
	}
}
