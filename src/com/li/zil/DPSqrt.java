package com.li.zil;

import java.util.ArrayList;
import java.util.List;

public class DPSqrt {
	int num;

	public int getNumber(int num) {
		this.num = num;

		return solution();
	}

	private int solution() {
		int max = (int) Math.sqrt(num);
		int[][] f = new int[max + 1][num + 1];
		List<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i <= max; i++) {
			for (int j = 0; j <= num; j++) {
				if (i == 0) {
					if (j == 0) {
						f[i][j] = 0;
					} else {
						f[i][j] = Integer.MAX_VALUE - num;
					}
				} else {
					for (int k = 0; k * i * i <= j; k++) {
						if (f[i][j] > f[i - 1][j - k * i * i] + k) {
							f[i][j] = f[i - 1][j - k * i * i] + k;
						}
					}
				}
			}
		}

		int j = num;
		for (int i = max; i >= 0; i--) {
			for (int k = 0; k < f[i][j]; k++) {
				res.add(i);
				j -= i * i;
			}
      if (j == 0) {
        break;
      }
		}

		return f[max][num];
	}
}
