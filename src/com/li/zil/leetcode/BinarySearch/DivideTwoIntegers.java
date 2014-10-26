package com.li.zil.leetcode.BinarySearch;

public class DivideTwoIntegers {
  // The idea is base on the failed one below.
  // To boost the process, it use bit manipulation to multiply the divisor by 2.
  public int divide(int dividend, int divisor) {
    boolean isPositive = true;
    long longDividend;
    long longDivisor;

    // Check if the result will be positive or not
    if (dividend < 0 ^ divisor < 0) {
      isPositive = false;
    }

    // In case of overflow by Integer.MIN_VALUE
    longDividend = Math.abs((long) dividend);
    longDivisor = Math.abs((long) divisor);

    int res = 0;

    // As long as the remaining dividend larger or equal to the divisor, continue
    while (longDivisor <= longDividend) {
      int pow = 1;
      // Try to subtract the dividend by the divisor multiple times until it is less than 0
      // To boost the process, each time multiply the divisor by 2 by bit operation...
      while ((longDivisor << pow) <= longDividend) {
        pow++;
      }

      res += 1 << (pow - 1);
      // Get the remaining dividend...
      longDividend -= longDivisor << (pow - 1);
    }

    return isPositive ? res : 0 - res;
  }

  // TLE...
  public int divideX(int dividend, int divisor) {
    boolean isPositive = true;

    if (dividend < 0 ^ divisor < 0) {
      isPositive = false;
    }

    if (dividend < 0) {
      dividend = 0 - dividend;
    }

    if (divisor < 0) {
      divisor = 0 - divisor;
    }

    int res = 0;
    int target = divisor;
    boolean cont = false;

    while (target <= dividend) {
      int low = 0;
      int high = dividend;
      cont = false;
      while (low <= high) {
        int mid = low + (high - low) / 2;
        if (mid == target) {
          target += divisor;
          res++;
          cont = true;
        } else if (mid < target) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
      if (cont) {
        continue;
      } else {
        break;
      }
    }

    return isPositive ? res : 0 - res;
  }
}
