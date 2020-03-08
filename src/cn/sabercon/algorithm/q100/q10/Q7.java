package cn.sabercon.algorithm.q100.q10;

/**
 * Reverse Integer
 * <p>
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * Input: 123
 * Output: 321
 * <p>
 * Example 2:
 * Input: -123
 * Output: -321
 * <p>
 * Example 3:
 * Input: 120
 * Output: 21
 * <p>
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * @author ywk
 * @date 2020-03-08
 */
public class Q7 {

    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if ((x > 0 && (Integer.MAX_VALUE - x) / 10 < result)
                    || (x < 0 && (Integer.MIN_VALUE - x) / 10 > result)) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Q7 q7 = new Q7();
        System.out.println(q7.reverse(199999998));
    }
}
