package cn.sabercon.algorithm.q100.q50;

/**
 * Pow(x,n)
 * <p>
 * Implement pow(x, n), which calculates x raised to the power n (x^n).
 * <p>
 * Example 1:
 * Input: 2.00000, 10
 * Output: 1024.00000
 * <p>
 * Example 2:
 * Input: 2.10000, 3
 * Output: 9.26100
 * <p>
 * Example 3:
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2^-2 = 1/2^2 = 1/4 = 0.25
 * <p>
 * Note:
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 *
 * @author ywk
 * @date 2020-03-14
 */
public class Q50 {

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long m = n;
        double result = myPositivePow(x, Math.abs(m));
        return m > 0 ? result : 1 / result;
    }

    private double myPositivePow(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        double half = myPositivePow(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }
}
