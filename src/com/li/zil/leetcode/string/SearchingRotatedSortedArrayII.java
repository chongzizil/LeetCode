package com.li.zil.leetcode.string;

public class SearchingRotatedSortedArrayII {
  // The worst case running time is O(n)
  // Because we may not be able to tell which half is sorted by comparing A[low] and A[mid]
  // e.g.    33133...
  public boolean search(int[] A, int target) {
    int low = 0;
    int high = A.length - 1;
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (A[mid] == target) {
        return true;
      }

      if (A[low] < A[mid]) {
        if (A[low] <= target && target < A[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else if (A[low] > A[mid]) {
        if (A[mid] < target && target <= A[high])
          low = mid + 1;
        else
          high = mid - 1;
      } else {
        low++;
      }
    }

    return false;
  }
}
