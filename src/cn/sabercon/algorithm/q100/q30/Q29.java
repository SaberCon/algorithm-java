package cn.sabercon.algorithm.q100.q30;

/**
 * Divide Two Integers
 * <p>
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * <p>
 * Example 2:
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * <p>
 * Note:
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 2^31 − 1 when the division result overflows
 *
 * @author ywk
 * @date 2020-03-10
 */
public class Q29 {

    public int divide(int dividend, int divisor) {
        boolean plus = true;
        if (dividend > 0) {
            plus = !plus;
            dividend = -dividend;
        }
        if (divisor > 0) {
            plus = !plus;
            divisor = -divisor;
        }
        int quotient = 0;
        int multi = 1;
        int multiDivisor = divisor;
        while (dividend <= divisor) {
            while (dividend > multiDivisor) {
                multiDivisor -= divisor;
                multi--;
            }
            dividend -= multiDivisor;
            if (quotient > Integer.MAX_VALUE - multi) {
                return plus ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            quotient += multi;
            multiDivisor += multiDivisor;
            multi += multi;
        }
        return plus ? quotient : -quotient;
    }
}
