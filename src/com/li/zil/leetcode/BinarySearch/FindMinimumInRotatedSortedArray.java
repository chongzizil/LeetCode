package com.li.zil.leetcode.BinarySearch;

public class FindMinimumInRotatedSortedArray {
  // This solution finds the pivot (which in my understanding is the smallest number...)
  public int findMin(int[] num) {
    int low = 0;
    int high = num.length - 1;

    // As long as the low number is larger then than the high one
    // Shrink the range...
    while (num[low] > num[high]) {
      int mid = low + (high - low) / 2;
      if (num[mid] > num[high]) {
        // Left is sorted
        low = mid + 1;
      } else {
        // Right is sorted
        high = mid;
      }
    }

    return num[low];
  }
}
