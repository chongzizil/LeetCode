package com.li.zil.leetcode.string;

public class AddBinary {
  public String addBinary(String a, String b) {
    if (a.length() < b.length()) {
      String tmp = a;
      a = b;
      b = tmp;
    }

    int la = a.length() - 1;
    int lb = b.length() - 1;
    int carries = 0;
    String res = "";

    while (la >= 0 && lb >= 0) {
      int sum = (a.charAt(la) - '0') + (b.charAt(lb) - '0') + carries;
      res = (sum % 2) + res;
      carries = sum / 2;
      la--;
      lb--;
    }

    while (la >= 0) {
      int sum = (a.charAt(la) - '0') + carries;
      res = (sum % 2) + res;
      carries = sum / 2;
      la--;
    }

    if (carries == 1) {
      res = '1' + res;
    }

    return res;
  }
}
