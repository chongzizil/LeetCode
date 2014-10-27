package com.li.zil.leetcode.LinkedList;

import com.li.zil.leetcode.ListNode;

public class PartitionList {
  public ListNode partition(ListNode head, int x) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode left = dummy;
    ListNode right = dummy;

    while (left.next != null && left.next.val < x) {
      left = left.next;
    }

    right = left.next;

    while (right != null && right.next != null) {
      if (right.next.val < x) {
        ListNode tmp = left.next;
        left.next = right.next;
        right.next = right.next.next;
        left.next.next = tmp;
        left = left.next;
      } else {
        right = right.next;
      }
    }

    return dummy.next;
  }
}
