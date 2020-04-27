package cn.sabercon.algorithm.q400.q360;

/**
 * Count Numbers with Unique Digits
 *
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.
 *
 * Example:
 *
 * Input: 2
 * Output: 91
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
 *              excluding 11,22,33,44,55,66,77,88,99
 *
 * @author ywk
 * @date 2020-04-27
 */
public class Q357 {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n > 10) {
            return countNumbersWithUniqueDigits(10);
        }
        int ans = 9;
        for (int i = 9; i > 10 - n; i--) {
            ans *= i;
        }
        return ans + countNumbersWithUniqueDigits(n - 1);
    }
}
