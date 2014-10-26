package com.li.zil.leetcode.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII {
  public List<Integer> getRow(int rowIndex) {
    List<Integer> res = new ArrayList<Integer>();
    int[] tmp = new int[rowIndex + 1];

    for (int row = 0; row <= rowIndex; row++) {
      for (int col = row; col >= 0; col--) {
        if (col == 0 || col == row) {
          tmp[col] = 1;
        } else {
          tmp[col] = tmp[col] + tmp[col - 1];
        }
      }
    }

    for (int i = 0; i <= rowIndex; i++) {
      res.add(tmp[i]);
    }

    return res;
  }
}
