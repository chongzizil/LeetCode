package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/8/7.
 */
public class ContainerWithMostWater {
	//
	public int maxArea(int[] height) {
		int maxArea = 0;

		for(int length = 1; length < height.length; length++) {
			for(int i = 0; i < height.length - length; i++) {
				maxArea = Math.max(maxArea, length * Math.max(height[i], height[i + length]));
			}
		}

		return maxArea;
	}
}
