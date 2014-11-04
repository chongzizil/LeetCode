package com.li.zil.leetcode.DP;

public class RegularExpressionMatching {
  // Not my solution...
  public boolean isMatch(String s, String p) {
    // If the string is empty, check if the p is 'empty' too
    // By empty, it can be literally empty or something like "a*.*"
    if (s.length() == 0) {
      return checkEmpty(p);
    }

    // If the p is empty and s not, return false
    if (p.length() == 0) {
      return false;
    }

    char s1 = s.charAt(0);
    char p1 = p.charAt(0);
    char p2 = '0';

    if (p.length() > 1){
      p2 = p.charAt(1);
    }

    if (p2 == '*') {
      if (compare(s1, p1)) {
        return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
      } else {
        return isMatch(s, p.substring(2));
      }
    } else {
      if (compare(s1, p1)) {
        return isMatch(s.substring(1), p.substring(1));
      }
      else {
        return false;
      }
    }
  }

  // Check if s and p are equal
  public boolean compare(char s, char p) {
    return p == '.' || s == p;
  }

  public boolean checkEmpty(String p) {
    if (p.length()%2 != 0) {
      return false;
    }

    for (int i = 1; i < p.length(); i+=2) {
      if (p.charAt(i) != '*') {
        return false;
      }
    }
    return true;
  }
}
