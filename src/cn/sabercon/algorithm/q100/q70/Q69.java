package cn.sabercon.algorithm.q100.q70;

/**
 * Sqrt(x)
 * <p>
 * Implement int sqrt(int x).
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * <p>
 * Example 1:
 * Input: 4
 * Output: 2
 * <p>
 * Example 2:
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 *
 * @author ywk
 * @date 2020-03-16
 */
public class Q69 {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        return binarySearch(x, 1, x > Math.sqrt(Integer.MAX_VALUE) ? (int) (Math.round(Math.sqrt(Integer.MAX_VALUE)) - 1) : x);
    }

    private int binarySearch(int x, int begin, int end) {
        if (begin * begin == x || (begin + 1) * (begin + 1) > x) {
            return begin;
        }
        if (end * end <= x) {
            return end;
        }
        int middle = (end - begin) / 2;
        if (middle * middle == x) {
            return middle;
        }
        if (middle * middle > x) {
            return binarySearch(x, begin + 1, middle - 1);
        } else {
            return binarySearch(x, middle, end - 1);
        }
    }
}
