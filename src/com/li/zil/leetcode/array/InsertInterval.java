package com.li.zil.leetcode.array;

import com.li.zil.leetcode.datastructure.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a O(n) solution and use O(n) space... It's a brilliant idea, yet not mine...
 */
public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> res = new ArrayList<Interval>();

		if (intervals == null || newInterval == null) {
			return intervals;
		}

		int pos = 0;

		for (Interval interval : intervals) {
			if (interval.end < newInterval.start) {
				res.add(interval);
				pos++;
			} else if (interval.start > newInterval.end) {
				res.add(interval);
			} else {
				newInterval.start = Math.min(newInterval.start, interval.start);
				newInterval.end = Math.max(newInterval.end, interval.end);
			}
		}

		res.add(pos, newInterval);

		return res;
	}
}
