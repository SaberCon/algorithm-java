package cn.sabercon.algorithm.q200.q190;

/**
 * Best Time to Buy and Sell Stock IV
 * <p>
 * Say you have an array for which the i-th element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * <p>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [2,4,1], k = 2
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 * <p>
 * Input: [3,2,6,5,0,3], k = 2
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
 *              Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *
 * @author ywk
 * @date 2020-03-29
 */
public class Q188 {

    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        if (k >= prices.length / 2) {
            return maxProfit(prices);
        }
        int[] dp = new int[prices.length + 1];
         for (int i = 0; i < k; i++) {
            int[] temp = new int[prices.length + 1];
            for (int j = 2; j < temp.length; j++) {
                int max = 0;
                int peak = prices[j - 1];
                for (int l = j - 2; l >= 0; l--) {
                    max = Math.max(max, dp[l] + peak - prices[l]);
                    peak = Math.max(peak, prices[l]);
                }
                temp[j] = Math.max(max, dp[j]);
            }
            dp = temp;
        }
        return dp[dp.length - 1];
    }

    private int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q188 q188 = new Q188();
        System.out.println(q188.maxProfit(2, new int[]{3,2,6,5,0,3}));
    }
}
