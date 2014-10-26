package com.li.zil.leetcode.LinkedList;

import com.li.zil.leetcode.ListNode;

public class SortList {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode slow = head;
    ListNode fast = head;
    ListNode mid;

    while (slow.next != null && fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    mid = slow;


    ListNode r = sortList(mid.next);
    mid.next = null;
    ListNode l = sortList(head);

    return merge(l, r);
  }

  private ListNode merge(ListNode l, ListNode r) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    while (r != null && l != null) {
      if (l.val <= r.val) {
        curr.next = l;
        l = l.next;
      } else {
        curr.next = r;
        r = r.next;
      }
      curr = curr.next;
    }

    if (r != null) {
      curr.next = r;
    } else if (l != null) {
      curr.next = l;
    }

    return dummy.next;
  }
}
