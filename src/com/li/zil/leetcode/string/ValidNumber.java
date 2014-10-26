package com.li.zil.leetcode.string;

public class ValidNumber {
  public boolean isNumberA(String s) {
    if (s == null) {
      return false;
    }

    s = s.trim();
    boolean hasNum = false;
    boolean hasDot = false;
    boolean hasE = false;

    if (s.length() == 0) {
      return false;
    }

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '+' || c == '-') {
        // '+' or '-' should be the first character of the number of right after 'e'
        if (!(i == 0 || s.charAt(i - 1) == 'e')) {
          return false;
        }
      } else if (c == '.') {
        // No '.' after the 'e'
        if (hasE || hasDot) {
          return false;
        }
        hasDot = true;
      } else if (c == 'e') {
        // Need at least one digit before 'e'
        if (hasE || !hasNum) {
          return false;
        }
        hasE = true;
        // Need at least one digit after 'e'
        hasNum = false;
      } else if (isDigit(c)) {
        hasNum = true;
      } else {
        return false;
      }
    }

    return hasNum;
  }
  // Can use Character.isDigit next time... if allowed
  public boolean isDigit(char c) {
    return c >= '0' && c <= '9';
  }

  // Another solution from others...
  public boolean isNumberB(String s) {
    int len = s.length();
    int i = 0, e = len - 1;
    while (i <= e && Character.isWhitespace(s.charAt(i))) i++;
    if (i > len - 1) return false;
    while (e >= i && Character.isWhitespace(s.charAt(e))) e--;
    // skip leading +/-
    if (s.charAt(i) == '+' || s.charAt(i) == '-') i++;
    boolean num = false; // is a digit
    boolean dot = false; // is a '.'
    boolean exp = false; // is a 'e'
    while (i <= e) {
      char c = s.charAt(i);
      if (Character.isDigit(c)) {
        num = true;
      }
      else if (c == '.') {
        if(exp || dot) return false;
        dot = true;
      }
      else if (c == 'e') {
        if(exp || num == false) return false;
        exp = true;
        num = false;
      }
      else if (c == '+' || c == '-') {
        if (s.charAt(i - 1) != 'e') return false;
      }
      else {
        return false;
      }
      i++;
    }
    return num;
  }
}
