package com.li.zil.leetcode.DP;

/**
 * Created by Zil on 2014/7/29.
 */
public class UniquePath {
    // A solution using DP
    public int uniquePathsA(int m, int n) {
	    int[][] path = new int[m][n];

	    for (int i = 0; i < m; i++) {
		    for (int j = 0; j < n; j++) {
			    if (i == 0 || j == 0) {
				    path[i][j] = 1;
			    } else {
				    path[i][j] = path[i - 1][j] + path[i][j - 1];
			    }
		    }
	    }

	    return path[m - 1][n - 1];
    }

    // A solution using DP with less space
    public int uniquePathsB(int m, int n) {
	    int[] path = new int[n];

	    for (int i = 0; i < m; i++) {
		    for (int j = 0; j < n; j++) {
			    if (i == 0 || j == 0) {
				    path[j] = 1;
			    } else {
				    path[j] = path[j] + path[j - 1];
			    }
		    }
	    }

	    return path[n - 1];
    }
}
