package com.li.zil.leetcode.LinkedList;

import com.li.zil.leetcode.ListNode;

/**
 * Created by youlongli on 10/28/14.
 */
public class RotateList {
  public ListNode rotateRightB(ListNode head, int n) {
    if (head == null) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    ListNode slow = head;
    ListNode fast = head;
    ListNode curr = head;
    dummy.next = head;
    int l = 1;
    int k = 0;

    while (curr.next != null) {
      curr = curr.next;
      l++;
    }

    k = n % l;

    if (k == 0) {
      return head;
    }

    for (int i = 0; i < k; i++) {
      fast = fast.next;
    }

    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }

    ListNode newHead = slow.next;
    curr = newHead;
    slow.next = null;
    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = dummy.next;
    dummy.next = newHead;

    return dummy.next;
  }

  // A more concise solution
  private int getLength(ListNode head) {
    int length = 0;
    while (head != null) {
      length ++;
      head = head.next;
    }
    return length;
  }

  public ListNode rotateRightC(ListNode head, int n) {
    if (head == null) {
      return null;
    }

    int length = getLength(head);
    n = n % length;

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;

    ListNode tail = dummy;
    for (int i = 0; i < n; i++) {
      head = head.next;
    }

    while (head.next != null) {
      tail = tail.next;
      head = head.next;
    }

    head.next = dummy.next;
    dummy.next = tail.next;
    tail.next = null;
    return dummy.next;
  }
}
