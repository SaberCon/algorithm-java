package cn.sabercon.algorithm.q100.q60;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * Merge Intevals
 * <p>
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * <p>
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * <p>
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 * @author ywk
 * @date 2020-03-15
 */
public class Q56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(n -> n[0]));
        Stack<int[]> stack = new Stack<>();
        for (int[] interval : intervals) {
            if (stack.isEmpty()) {
                stack.push(interval);
            } else {
                int[] ints = stack.peek();
                if (ints[1] >= interval[0]) {
                    ints[1] = Math.max(ints[1], interval[1]);
                } else {
                    stack.push(interval);
                }
            }
        }
        int[][] result = new int[stack.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop();
        }
        return result;
    }
}
