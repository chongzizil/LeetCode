package com.li.zil.leetcode;

/**
 * This is one really brilliant solution from 12344! It took me quite a while to figure out this
 * outbox idea.
 * So the idea is for left bar and right bar, we calculate all possible areas between them at
 * certain heights (levels). Therefore at last the variable all will contains all possible areas.
 * Then if we can calculate the areas of the blocks of 'all', the rest will be the result we want!
 */
public class TrappingRainWater {
	public int trap(int[] A) {
		int currLevel = 0;
		int all = 0;
		int block = 0;
		int l = 0;
		int r = A.length - 1;

		if (A.length == 0) {
			return 0;
		}

		while (l <= r) {
			if (Math.min(A[l], A[r]) > currLevel) {
				// Both bar are higher than the current bar, calculate the possible area for the levels
				// high then the current bar and lower than the lowest bar of the left and right current
				// bar.
				all += (Math.min(A[l], A[r]) - currLevel) * (r - l + 1);
				// Update the new current bar's level.
				currLevel = Math.min(A[l], A[r]);
			}

			// Get the shortest bar from the current left and right, and calculate the blocks and move on.
			if (A[l] >= A[r]) {
				block += A[r--];
			} else {
				block += A[l++];
			}
		}

		return all - block;
	}
}
