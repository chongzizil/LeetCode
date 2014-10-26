package com.li.zil.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		if (numRows < 1) {
			List<Integer> tmp = new ArrayList<Integer>();
			return res;
		}

		for (int i = 0; i < numRows; i++) {
			List<Integer> tmp = new ArrayList<Integer>();

			if ( i == 0 ){
				tmp.add(1);
				res.add(tmp);
			} else {
				List<Integer> prev = res.get(i - 1);
				for ( int j = 0; j <= i; j++ ){
					if ( j == 0 ) {
						tmp.add(1);
					} else if ( j == i ) {
						tmp.add(1);
					} else{
						tmp.add(prev.get(j - 1)+prev.get(j));
					}
				}
				res.add(tmp);
			}
		}

		return res;
	}
}
