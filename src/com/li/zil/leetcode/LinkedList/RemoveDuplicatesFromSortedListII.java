package com.li.zil.leetcode.LinkedList;

import com.li.zil.leetcode.ListNode;

public class RemoveDuplicatesFromSortedListII {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0);
    ListNode curr = head;
    ListNode prev = dummy;
    dummy.next = head;

    if (head == null) {
      return head;
    }

    while (curr != null && curr.next != null) {
      if (curr.val == curr.next.val) {
        while (curr.next != null && curr.val == curr.next.val) {
          curr.next = curr.next.next;
        }
        prev.next = curr.next;
        curr = prev.next;
      } else {
        curr = curr.next;
        prev = prev.next;
      }
    }

    return dummy.next;
  }
}
