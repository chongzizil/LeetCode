package com.li.zil.leetcode.string;

public class ZigZagConversion {
  // An optimized version of B enlightened by C
  public String convertA(String s, int nRows) {
    int n = s.length() - 1;
    StringBuilder sb = new StringBuilder();

    if (nRows >= s.length() || nRows == 1) {
      return s;
    }

    for (int i = 0; i < nRows; i++) {
      int start = i;
      int step = (nRows - 1) * 2;
      int interval = step - i * 2;

      while (start <= n) {
        sb.append(s.charAt(start));

        if (interval != 0 && interval != step && start + interval <= n) {
          sb.append(s.charAt(start + interval));
        }
        start += step;
      }
    }

    return sb.toString();
  }

  // A simple solution, not very concise and efficient though..
  public String convertB(String s, int nRows) {
    int n = s.length() - 1;
    String res = "";

    if (nRows == 1) {
      return s;
    }

    for (int i = 0; i < nRows; i++) {
      int start = i;
      if (i == 0 || i == nRows - 1) {
        int step = (nRows - 1) * 2;
        while (start <= n) {
          res += s.charAt(start);
          start += step;
        }
      } else {
        int step1 = (nRows - i - 1) * 2;
        int step2 = i * 2;
        while (start <= n) {
          res += s.charAt(start);
          start += step1;
          if (start > n) {
            break;
          }
          res += s.charAt(start);
          start += step2;
        }
      }
    }

    return res;
  }

  // Solution from others
  public String convertC(String s, int nRows) {
    int length = s.length();
    if (length <= nRows || nRows == 1) return s;
    char[] chars = new char[length];
    int step = 2 * (nRows - 1);
    int count = 0;
    for (int i = 0; i < nRows; i++){
      int interval = step - 2 * i;
      for (int j = i; j < length; j += step){
        chars[count] = s.charAt(j);
        count++;
        if (interval < step && interval > 0
            && j + interval < length && count <  length){
          chars[count] = s.charAt(j + interval);
          count++;
        }
      }
    }
    return new String(chars);
  }
}
