package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/7/14.
 */
public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i-1]) {
				maxProfit += prices[i] - prices[i-1];
			}
		}

		return maxProfit;
	}
}