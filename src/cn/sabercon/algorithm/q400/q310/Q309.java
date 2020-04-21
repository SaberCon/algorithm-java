package cn.sabercon.algorithm.q400.q310;

/**
 * Best Time to Buy and Sell Stock with Cooldown
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 *
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 *
 * @author ywk
 * @date 2020-04-20
 */
public class Q309 {

    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0) {
            return 0;
        }
        // 当天持有
        int[] dpBuy = new int[length];
        // 当天卖出
        int[] dpSell = new int[length];
        // 当天未持有
        int[] dpNo = new int[length];
        for (int i = 1; i < length; i++) {
            dpBuy[i] = Math.max(dpBuy[i - 1] + prices[i] - prices[i - 1], dpNo[i - 1]);
            dpSell[i] = dpBuy[i - 1] + prices[i] - prices[i - 1];
            dpNo[i] = Math.max(dpNo[i - 1], dpSell[i - 1]);
        }
        return Math.max(dpBuy[length - 1], Math.max(dpSell[length - 1], dpNo[length - 1]));
    }
}
