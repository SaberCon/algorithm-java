package cn.sabercon.algorithm.q300.q240;

/**
 * Number of Digit One
 * <p>
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 * <p>
 * Example:
 * <p>
 * Input: 13
 * Output: 6
 * Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 *
 * @author ywk
 * @date 2020-04-10
 */
public class Q233 {

    public int countDigitOne(int n) {
        int ans = 0;
        for (long i = 1; i <= n; i *= 10) {
            ans += i * (n / (i * 10)) + Math.max(0, Math.min(i, n % (i * 10) - i + 1));
        }
        return ans;
    }
}
