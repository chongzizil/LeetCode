package com.li.zil.leetcode.string;

public class CountAndSay {
  public String countAndSayA(int n) {
    String res = "1";
    for (int i = 1; i < n; i++) {
      res = convertA(res);
    }

    return res;
  }

  private String convertA(String s) {
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int count = 1;
      while (i + 1 < s.length() && s.charAt(i + 1) == c) {
        count++;
        i++;
      }
      res.append(String.valueOf(count)).append(c);
    }

    return res.toString();
  }

  // TLE and wrong answer... I misunderstood the problem...
  public String countAndSayX(int n) {
    String res = "1";
    for (int i = 0; i < n; i++) {
      res = convertX(res);
    }

    return res;
  }

  private String convertX(String s) {
    String res = "";
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '1') {
        if (i + 1 < s.length() && s.charAt(i + 1) == '1') {
          res += "21";
          i++;
        } else {
          res += "11";
        }
      } else {
        res += "1211";
        i++;
      }
    }

    return res;
  }
}
