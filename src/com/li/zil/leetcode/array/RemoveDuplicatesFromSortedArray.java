package com.li.zil.leetcode.array;

/**
 * Created by youlongli on 10/28/14.
 */
public class RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }

    int size = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[size] != A[i]) {
        size++;
        A[size] = A[i];
      }
    }

    // Plus 1 since size is zero based
    return size + 1;
  }
}
