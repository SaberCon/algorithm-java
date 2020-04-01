package cn.sabercon.algorithm.q300.q210;

/**
 * Bitwise AND of Numbers Range
 *
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 *
 * Example 1:
 *
 * Input: [5,7]
 * Output: 4
 * Example 2:
 *
 * Input: [0,1]
 * Output: 0
 *
 * @author ywk
 * @date 2020-03-30
 */
public class Q201 {

    public int rangeBitwiseAnd(int m, int n) {
        int zeros = 0;
        while (n > m) {
            zeros++;
            m >>>= 1;
            n >>>= 1;
        }
        //将 0 的个数空出来
        return m << zeros;
    }
}
