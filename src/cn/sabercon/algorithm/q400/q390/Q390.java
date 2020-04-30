package cn.sabercon.algorithm.q400.q390;

/**
 * Elimination Game
 * <p>
 * There is a list of sorted integers from 1 to n. Starting from left to right,
 * remove the first number and every other number afterward until you reach the end of the list.
 * <p>
 * Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.
 * <p>
 * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 * <p>
 * Find the last number that remains starting with a list of length n.
 * <p>
 * Example:
 * <p>
 * Input:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 * <p>
 * Output:
 * 6
 *
 * @author ywk
 * @date 2020-04-30
 */
public class Q390 {

    public int lastRemaining(int n) {
        return lastRemaining(n, false);
    }

    private int lastRemaining(int n, boolean reverse) {
        if (n == 1) {
            return 1;
        }
        return 2 * lastRemaining(n / 2, !reverse) - (reverse & n % 2 == 0 ? 1 : 0);
    }

    public static void main(String[] args) {
        // 1 2 3 4 5 6
        // 2 4 6
        // 4
    }
}
