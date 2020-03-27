package cn.sabercon.algorithm.q200.q180;

/**
 * Factorial Trailing Zeroes
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 *
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 *
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Note: Your solution should be in logarithmic time complexity.
 *
 * @author ywk
 * @date 2020-03-27
 */
public class Q172 {

    public int trailingZeroes(int n) {
        int result = 0;
        int i = n;
        while (i != 0) {
            i /= 5;
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        Q172 q172 = new Q172();
        System.out.println(q172.trailingZeroes(20));
    }
}
