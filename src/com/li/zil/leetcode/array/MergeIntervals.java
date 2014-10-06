package com.li.zil.leetcode.array;

import com.li.zil.leetcode.datastructure.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();

		if (intervals == null || intervals.size() == 0) {
			return res;
		}

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});

		int n = intervals.size();
		int i = 0;

		while (i < n) {
			Interval curr = intervals.get(i);
			int j = i + 1;
			while (j < n && intervals.get(j).start <= curr.end) {
				curr.end = Math.max(intervals.get(j).end, curr.end);
				j++;
			}
			res.add(curr);
			i = j;
		}

		return res;
	}
}
