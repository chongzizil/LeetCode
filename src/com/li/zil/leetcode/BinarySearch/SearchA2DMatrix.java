package com.li.zil.leetcode.BinarySearch;

public class SearchA2DMatrix {
  // Double binary search...
  public boolean searchMatrix(int[][] matrix, int target) {
    int row = -1;
    int low = 0;
    int high = matrix.length - 1;

    // First search for the row number
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (matrix[mid][0] == target) {
        return true;
      } else if (matrix[mid][0] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    // row should be the largest index which is smaller than the target
    row = high;
    // The target is smaller than the smallest number in the matrix...
    if (row < 0) {
      return false;
    }

    low = 0;
    high = matrix[row].length - 1;

    // Now search for the number in {@code row}
    while (low <= high) {
      int mid = low + (high - low) / 2;
      if (matrix[row][mid] == target) {
        return true;
      } else if (matrix[row][mid] > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    // Does not exist...
    return false;
  }
}
