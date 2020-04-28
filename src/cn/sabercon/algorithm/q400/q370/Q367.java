package cn.sabercon.algorithm.q400.q370;

/**
 * Valid Perfect Square
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 14
 * Output: false
 *
 * @author ywk
 * @date 2020-04-28
 */
public class Q367 {

    public static boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            long square = ((long) middle) * middle;
            if (square == num) {
                return true;
            }
            if (square > num) {
                end = middle - 1;
            }
            if (square < num) {
                start = middle + 1;
            }
        }
        return false;
    }
}
