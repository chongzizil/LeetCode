package com.li.zil.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by Zil on 2014/7/28.
 */
public class GenerateParentheses {
  // This is a recursive solution...
  public List<String> generateParenthesisA(int n) {
    List<String> res = new ArrayList<String>();

    List<String> parenthesis = new ArrayList<String>();
    int left = n - 1;
    int right = n;

    parenthesis.add("(");

    helper(res, parenthesis, left, right);

    return res;
  }

  private void helper(List<String> res, List<String> parenthesis, int left, int right) {
    if (left == 0 && right == 0) {
      StringBuilder sb = new StringBuilder();
      for (String s : parenthesis) {
        sb.append(s);
      }
      res.add(sb.toString());
      return;
    }

    if (left >= 0) {
      List<String> tmp = new ArrayList<String>(parenthesis);
      tmp.add("(");
      helper(res, tmp, left - 1, right);
    }

    if (right >= 0 && right > left) {
      List<String> tmp = new ArrayList<String>(parenthesis);
      tmp.add(")");
      helper(res, tmp, left, right - 1);
    }
  }

  // This is a iterative solution
  public List<String> generateParenthesisB(int n) {
    List<String> res = new ArrayList<String>();
    Deque<String> queue = new ArrayDeque<String>();
    Deque<Integer> leftQueue = new ArrayDeque<Integer>();
    Deque<Integer> rightQueue = new ArrayDeque<Integer>();
    Deque<Integer> countOfClosedQueue = new ArrayDeque<Integer>();

    queue.addLast("(");
    leftQueue.addLast(n - 1);
    rightQueue.addLast(n);
    countOfClosedQueue.addLast(0);

    while (!queue.isEmpty()) {
      String str = queue.pollFirst();
      int left = leftQueue.pollFirst();
      int right = rightQueue.pollFirst();
      int countOfClosed = countOfClosedQueue.pollFirst();

      if (countOfClosed == n) {
        res.add(str);
      }
      if (left > 0) {
        queue.addLast(str + "(");
        leftQueue.addLast(left - 1);
        rightQueue.addLast(right);
        countOfClosedQueue.addLast(countOfClosed);
      }
      if (right > 0 && (n - left > n - right)) {
        queue.addLast(str + ")");
        leftQueue.addLast(left);
        rightQueue.addLast(right - 1);
        countOfClosedQueue.addLast(n - (right - 1));
      }
    }

    return res;
  }
}
