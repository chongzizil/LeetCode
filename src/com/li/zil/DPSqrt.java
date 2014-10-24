package com.li.zil;

import java.util.ArrayList;
import java.util.List;

public class DPSqrt {
	int n;

	public int getNumber(int n) {
		this.n = n;

		return solution();
	}

	private int solution() {
		int res = 0;
		int maxSqrt = (int) Math.sqrt(n);
		int[][] f = new int[maxSqrt + 1][n + 1];
		int[] res2 = new int[maxSqrt + 1];

		for (int i = 0; i <= maxSqrt; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0) {
					if (j == 0) {
						f[i][j] = 0;
					} else {
						f[i][j] = Integer.MAX_VALUE;
					}
				} else {
					for (int k = 0; k <= j / (i * i); k++) {
						f[i][j] = Math.min(f[i - 1][j], f[i - 1][j - k * (i * i)] + k);
					}
				}
			}
		}

		List<Integer> resList = new ArrayList<Integer>();

		res = f[maxSqrt][n];

		return res;
	}

//	private List<Integer> getResList(List<Integer> res) {
//
//	}

}
