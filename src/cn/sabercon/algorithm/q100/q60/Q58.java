package cn.sabercon.algorithm.q100.q60;

import java.util.Stack;

/**
 * Insert Interval
 * <p>
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * <p>
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 * <p>
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature
 *
 * @author ywk
 * @date 2020-03-15
 */
public class Q58 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        boolean inserted = false;
        Stack<int[]> stack = new Stack<>();
        for (int[] interval : intervals) {
            if (inserted) {
                int[] ints = stack.peek();
                if (ints[1] >= interval[0]) {
                    ints[1] = Math.max(ints[1], interval[1]);
                } else {
                    stack.push(interval);
                }
            } else {
                if (newInterval[0] > interval[1]) {
                    stack.push(interval);
                } else if (newInterval[1] < interval[0]) {
                    stack.push(newInterval);
                    stack.push(interval);
                    inserted = true;
                } else {
                    newInterval[0] = Math.min(newInterval[0], interval[0]);
                    newInterval[1] = Math.max(newInterval[1], interval[1]);
                    stack.push(newInterval);
                    inserted = true;
                }
            }
        }
        if (!inserted) {
            stack.push(newInterval);
        }
        int[][] result = new int[stack.size()][2];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
