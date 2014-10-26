package com.li.zil.leetcode.BinarySearch;

public class SQRT {
  public int sqrt(int x) {
    long low = 0;
    long high = x;

    while (low <= high) {
      long mid = low + (high - low) / 2;
      long i = mid * mid;

      if (mid <= x) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return (int) high;
  }
}
