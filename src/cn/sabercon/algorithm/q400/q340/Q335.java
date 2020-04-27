package cn.sabercon.algorithm.q400.q340;

/**
 * Self Cross
 * <p>
 * You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north,
 * then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on.
 * In other words, after each move your direction changes counter-clockwise.
 * <p>
 * Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.
 * <p>
 * Example 1:
 * <p>
 * ┌───┐
 * │   │
 * └───┼──>
 *     │
 * <p>
 * Input: [2,1,1,2]
 * Output: true
 * Example 2:
 * <p>
 * ┌──────┐
 * │      │
 * │
 * │
 * └────────────>
 * <p>
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 * <p>
 * ┌───┐
 * │   │
 * └───┼>
 * <p>
 * Input: [1,1,1,1]
 * Output: true
 *
 * @author ywk
 * @date 2020-04-26
 */
public class Q335 {

    public static boolean isSelfCrossing(int[] x) {
        for (int i = 3; i < x.length; i++) {
            if (x[i - 1] <= x[i - 3] && x[i] >= x[i - 2]) {
                return true;
            }
            if (i > 4 && x[i - 2] > x[i - 4] && x[i - 1] < x[i - 3] && x[i] + x[i - 4] >= x[i - 2] && x[i - 1] + x[i - 5] >= x[i - 3]) {
                return true;
            }
        }
        return x.length > 4 && x[3] == x[1] && x[4] + x[0] >= x[2];
    }

    public static void main(String[] args) {
        System.out.println(isSelfCrossing(new int[]{1,1,2,2,3,3,4,4,10,4,4,3,3,2,2,1,1}));
    }
}
