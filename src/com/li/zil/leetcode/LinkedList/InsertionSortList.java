package com.li.zil.leetcode.LinkedList;

import com.li.zil.leetcode.ListNode;

public class InsertionSortList {
  public ListNode insertionSortList(ListNode head) {
    ListNode dummy = new ListNode(0);
    ListNode prev = dummy;
    ListNode curr = head;
    dummy.next = head;

    while (curr != null) {
      if (curr == head || curr.val > prev.val) {
        prev = curr;
        curr = curr.next;
        continue;
      }

      ListNode start = dummy;
      while (start.next.val < curr.val && start.next != curr) {
        start = start.next;
      }

      ListNode tmp = curr.next;
      curr.next = start.next;
      start.next = curr;
      prev.next = tmp;
      curr = prev.next;
    }

    return dummy.next;
  }
}
