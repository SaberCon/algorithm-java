package cn.sabercon.algorithm.q400.q330;


import java.util.HashMap;
import java.util.Map;

/**
 * Coin Change
 * <p>
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 * <p>
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 * @author ywk
 * @date 2020-04-23
 */
public class Q322 {

    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount, new HashMap<>());
    }

    private int dp(int[] coins, int amount, Map<Integer, Integer> map) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (map.containsKey(amount)) {
            return map.get(amount);
        }
        int min = -1;
        for (int coin : coins) {
            int count = dp(coins, amount - coin, map);
            if (count != -1) {
                min = min == -1 ? count + 1 : Math.min(min, count + 1);
            }
        }
        map.put(amount, min);
        return min;
    }

}
