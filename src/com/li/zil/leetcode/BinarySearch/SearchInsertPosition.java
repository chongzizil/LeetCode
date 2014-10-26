package com.li.zil.leetcode.BinarySearch;

public class SearchInsertPosition {
  // If the number does not exist, simply find the next index
  // right after the largest number which is smaller than the target...
  public int searchInsert(int[] A, int target) {
    int low = 0;
    int high = A.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (target == A[mid]) {
        return mid;
      } else if (target < A[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return low;
  }
}
