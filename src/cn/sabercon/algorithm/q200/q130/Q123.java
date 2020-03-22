package cn.sabercon.algorithm.q200.q130;

import java.util.PriorityQueue;

/**
 * Best Time to Buy and Sell Stock III
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *              Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 * <p>
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 * <p>
 * Example 3:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * <p>
 *
 * @author ywk
 * @date 2020-03-22
 */
public class Q123 {

    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[] maxProfits = new int[prices.length];
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
            maxProfits[i] = maxProfit;
        }
        maxProfit = 0;
        int totalProfit = 0;
        int maxPrice = prices[prices.length - 1];
        for (int i = prices.length - 2; i > 0; i--) {
            maxProfit = Math.max(maxProfit, maxPrice - prices[i]);
            maxPrice = Math.max(maxPrice, prices[i]);
            totalProfit = Math.max(totalProfit, maxProfits[i - 1] + maxProfit);
        }
        return Math.max(totalProfit, maxProfits[maxProfits.length - 1]);
    }

}
