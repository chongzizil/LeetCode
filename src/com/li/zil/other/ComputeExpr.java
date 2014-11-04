package com.li.zil.other;

import java.util.ArrayDeque;
import java.util.Deque;

public class ComputeExpr {
  public int compute(String expr) {
    Deque<Integer> numStack = new ArrayDeque<Integer>();
    Deque<String> optStack = new ArrayDeque<String>();
    int i = 0;
    int n = expr.length();
    int currNum = 0;
    boolean isNegative = false;

    while (i < n) {
      if (expr.charAt(i) == '-' || expr.charAt(i) == '+') {
        if (i == 0 || expr.charAt(i - 1) == '-') {
          isNegative = true;
          i++;
        } else if (Character.isDigit(expr.charAt(i - 1))) {

        }
      }
    }

  }
}
