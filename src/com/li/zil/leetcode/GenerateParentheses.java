package com.li.zil.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by Zil on 2014/7/28.
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        Deque<String> queue = new ArrayDeque<String>();
        Deque<Integer> leftQueue = new ArrayDeque<Integer>();
        Deque<Integer> rightQueue = new ArrayDeque<Integer>();
        Deque<Integer> countOfClosedQueue = new ArrayDeque<Integer>();

        queue.addLast("(");
        leftQueue.addLast(n - 1);
        rightQueue.addLast(n);
        countOfClosedQueue.addLast(0);

        while(!queue.isEmpty()) {
            String str = queue.pollFirst();
            int left = leftQueue.pollFirst();
            int right = rightQueue.pollFirst();
            int countOfClosed = countOfClosedQueue.pollFirst();

            if (countOfClosed == n) {
                res.add(str);
            }
            if (left > 0) {
                queue.addLast(str + "(");
                leftQueue.addLast(left - 1);
                rightQueue.addLast(right);
                countOfClosedQueue.addLast(countOfClosed);
            }
            if (right > 0 && (n - left > n - right)) {
                queue.addLast(str + ")");
                leftQueue.addLast(left);
                rightQueue.addLast(right - 1);
                countOfClosedQueue.addLast(n - (right - 1));
            }
        }

        return res;
    }
}
