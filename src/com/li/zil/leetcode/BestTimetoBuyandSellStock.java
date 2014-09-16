package com.li.zil.leetcode;

/**
 * Created by Zil on 2014/7/30.
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        int lowest;
        int maxProfit;

        if (prices.length < 2) {
            return 0;
        }

        lowest = prices[0];
        maxProfit = 0;

        for(int i = 1; i < prices.length; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - lowest);
            }
        }

        return maxProfit;
    }
}
