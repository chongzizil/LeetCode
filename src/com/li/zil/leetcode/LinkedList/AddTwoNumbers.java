package com.li.zil.leetcode.LinkedList;

import com.li.zil.leetcode.ListNode;

public class AddTwoNumbers {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carries = 0;
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    while (l1 != null && l2 != null) {
      int sum = l1.val + l2.val + carries;
      ListNode node = new ListNode(sum % 10);
      curr.next = node;
      carries = sum / 10;

      l1 = l1.next;
      l2 = l2.next;
      curr = curr.next;
    }

    while (l1 != null) {
      int sum = l1.val + carries;
      ListNode node = new ListNode(sum % 10);
      curr.next = node;
      carries = sum / 10;

      l1 = l1.next;
      curr = curr.next;
    }

    while (l2 != null) {
      int sum = l2.val + carries;
      ListNode node = new ListNode(sum % 10);
      curr.next = node;
      carries = sum / 10;

      l2 = l2.next;
      curr = curr.next;
    }

    if (carries == 1) {
      ListNode node = new ListNode(1);
      curr.next = node;
    }

    return dummy.next;
  }
}
