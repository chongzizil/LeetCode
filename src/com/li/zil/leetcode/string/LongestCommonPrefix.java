package com.li.zil.leetcode.string;

import java.util.Arrays;

public class LongestCommonPrefix {
  // This solution pick the first string and compare to other
  // string one at a time, shrink the result if necessary until
  // the end...
  public String longestCommonPrefixA(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }

    String res = strs[0];

    for (int i = 1; i < strs.length; i++) {
      int minLength = Math.min(res.length(), strs[i].length());
      int end = minLength;
      for (int j = minLength - 1; j >= 0; j--) {
        if (res.charAt(j) != strs[i].charAt(j)) {
          end = j;
        }
      }
      res = res.substring(0, end);
    }
    return res;
  }

  // This solution will get each character from left to right
  // and compare to all the strings corresponding character until
  // the end...
  public String longestCommonPrefixB(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }

    int minLength = Integer.MAX_VALUE;
    String res = "";
    boolean hasFound = false;

    for (int i = 0; i < strs.length; i++) {
      minLength = Math.min(minLength, strs[i].length());
    }

    for (int i = 0; i < minLength; i++) {
      String tmp = res;
      tmp += strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (!strs[j].substring(0, i + 1).equals(tmp)) {
          hasFound = true;
          break;
        }
      }
      if (hasFound) {
        break;
      }
      res = tmp;
    }

    return res;
  }
}
