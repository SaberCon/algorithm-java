package cn.sabercon.algorithm.q400.q320;

/**
 * Super Ugly Number
 * <p>
 * Write a program to find the nth super ugly number.
 * <p>
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 * <p>
 * Example:
 * <p>
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
 * super ugly numbers given primes = [2,7,13,19] of size 4.
 * Note:
 * <p>
 * 1 is a super ugly number for any given primes.
 * The given numbers in primes are in ascending order.
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 *
 * @author ywk
 * @date 2020-04-21
 */
public class Q313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;

        int k = primes.length;
        int[] index = new int[k];

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                min = Math.min(min, dp[index[j]] * primes[j]);
            }
            dp[i] = min;
            for (int j = 0; j < k; j++) {
                if (min == dp[index[j]] * primes[j]) {
                    index[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}
