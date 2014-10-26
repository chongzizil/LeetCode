package com.li.zil.leetcode.BinarySearch;

/**
 * Created by youlongli on 10/25/14.
 */
public class SearchForARange {
  public int[] searchRangeA(int[] A, int target) {
    int[] res = new int[2];
    int lower = searchLower(A, target);

    if (lower == -1) {
      res[0] = -1;
      res[1] = -1;
      return res;
    }

    int upper = searchUpper(A, target);

    res[0] = lower;
    res[1] = upper;

    return res;
  }

  private int searchLower(int[] A, int target) {
    int res = -1;
    int low = 0;
    int high = A.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (A[mid] == target) {
        res = mid;
        high = mid - 1;
      } else if (A[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    if (res != -1) {
      return low;
    } else {
      return -1;
    }
  }

  private int searchUpper(int[] A, int target) {
    int low = 0;
    int high = A.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (A[mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return high;
  }

  // Another solution which uses a slightly different binary search...
  public int[] searchRangeB(int[] A, int target) {
    int start, end, mid;
    int[] bound = new int[2];

    // search for left bound
    start = 0;
    end = A.length - 1;
    while (start + 1 < end) {
      mid = start + (end - start) / 2;
      if (A[mid] == target) {
        end = mid;
      } else if (A[mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
    }
    if (A[start] == target) {
      bound[0] = start;
    } else if (A[end] == target) {
      bound[0] = end;
    } else {
      bound[0] = bound[1] = -1;
      return bound;
    }

    // search for right bound
    start = 0;
    end = A.length - 1;
    while (start + 1 < end) {
      mid = start + (end - start) / 2;
      if (A[mid] == target) {
        start = mid;
      } else if (A[mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
    }
    if (A[end] == target) {
      bound[1] = end;
    } else if (A[start] == target) {
      bound[1] = start;
    } else {
      bound[0] = bound[1] = -1;
      return bound;
    }

    return bound;
  }
}
