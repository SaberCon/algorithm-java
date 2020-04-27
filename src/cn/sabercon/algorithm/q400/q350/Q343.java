package cn.sabercon.algorithm.q400.q350;

/**
 * Integer Break
 *
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers.
 * Return the maximum product you can get.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 *
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * Note: You may assume that n is not less than 2 and not larger than 58.
 *
 * @author ywk
 * @date 2020-04-27
 */
public class Q343 {

    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        return integerBreak(n, new int[n + 1]);
    }

    private int integerBreak(int n, int[] cache) {
        if (n < 4) {
            return n;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        int max = 0;
        for (int i = 2; i <= n / 2; i++) {
            max = Math.max(max, integerBreak(i, cache) * integerBreak(n - i, cache));
        }
        cache[n] = max;
        return max;
    }
}
