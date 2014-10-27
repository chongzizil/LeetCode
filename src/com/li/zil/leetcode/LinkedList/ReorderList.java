package com.li.zil.leetcode.LinkedList;

import com.li.zil.leetcode.ListNode;

public class ReorderList {
  // This is a tricky problem... A lot of things can go wrong but it's a good practice
  // for linked list...
  public void reorderList(ListNode head) {
    ListNode dummyNode = new ListNode(0);
    ListNode left = head;
    ListNode right;
    ListNode mid;

    if (head == null || head.next == null) {
      return;
    }

    mid = getMiddleNode(head);

    right = reverseNode(mid.next);

    mid.next = null;

    while (left != null && right != null) {
      dummyNode.next = left;
      dummyNode = dummyNode.next;
      left = left.next;
      dummyNode.next = right;
      dummyNode = dummyNode.next;
      right = right.next;
    }

    while (left != null) {
      dummyNode.next = left;
      dummyNode = dummyNode.next;
      left = left.next;
    }
  }

  private ListNode getMiddleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (slow.next != null && fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  private ListNode reverseNode(ListNode head) {
    ListNode dummyNode = new ListNode(0);
    ListNode curr = head;
    dummyNode.next = head;

    while (curr.next != null) {
      ListNode tmp = dummyNode.next;
      dummyNode.next = curr.next;
      curr.next = curr.next.next;
      dummyNode.next.next = tmp;
    }

    return dummyNode.next;
  }
}
