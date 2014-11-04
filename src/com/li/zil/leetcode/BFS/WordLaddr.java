package com.li.zil.leetcode.BFS;

import java.util.*;

/**
 * Created by youlongli on 10/31/14.
 */
public class WordLaddr {
  // TLE
  public int ladderLength(String start, String end, Set<String> dict) {
    Deque<String> queue = new ArrayDeque<String>();
    int i = 0;
    int length = 0;
    int size = dict.size();

    queue.addLast(start);
    dict.remove(start);

    while (!queue.isEmpty() && i < size) {
      String token = queue.pollFirst();
      if (getDiffNum(token, end) == 0) {
        length = i;
        break;
      }
      List<String> tmp = new ArrayList<String>();
      for (String s : dict) {
        int diff = getDiffNum(token, s);
        if (diff == 1) {
          queue.addLast(s);
          tmp.add(s);
        }
      }

      for (String s : tmp) {
        dict.remove(s);
      }
      i++;
    }

    return length;
  }

  private int getDiffNum(String s, String p) {
    int diff = 0;
    for (int i = 0; i < p.length(); i++) {
      if (s.charAt(i) != p.charAt(i)) {
        diff++;
      }
    }
    return diff;
  }
}
