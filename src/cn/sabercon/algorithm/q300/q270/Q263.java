package cn.sabercon.algorithm.q300.q270;

/**
 * Ugly Number
 * <p>
 * Write a program to check whether a given number is an ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * <p>
 * Example 1:
 * <p>
 * Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * Example 2:
 * <p>
 * Input: 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 * Example 3:
 * <p>
 * Input: 14
 * Output: false
 * Explanation: 14 is not ugly since it includes another prime factor 7.
 * Note:
 * <p>
 * 1 is typically treated as an ugly number.
 * Input is within the 32-bit signed integer range: [−231,  231 − 1].
 *
 * @author ywk
 * @date 2020-04-12
 */
public class Q263 {

    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 5 == 0) {
                num /= 5;
            } else {
                return false;
            }
        }
        return true;
    }
}
