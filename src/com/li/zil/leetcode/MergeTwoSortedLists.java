package com.li.zil.leetcode;

public class MergeTwoSortedLists {
	// Use a dummy head node, the logic is more simple and clear...
	public ListNode mergeTwoLists_A(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode lastNode = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				lastNode.next = l1;
				l1 = l1.next;
			} else {
				lastNode.next = l2;
				l2 = l2.next;
			}
			lastNode = lastNode.next;
		}

		if (l1 != null) {
			lastNode.next = l1;
		} else {
			lastNode.next = l2;
		}

		return dummy.next;
	}

	public ListNode mergeTwoLists_B(ListNode l1, ListNode l2) {
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
