package cn.sabercon.algorithm.q300.q240;

/**
 * Power of Two
 *
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 2^0 = 1
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 2^4 = 16
 * Example 3:
 *
 * Input: 218
 * Output: false
 *
 * @author ywk
 * @date 2020-04-09
 */
public class Q231 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.lowestOneBit(n) == Integer.highestOneBit(n);
    }
}
