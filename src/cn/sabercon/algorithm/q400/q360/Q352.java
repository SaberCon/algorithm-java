package cn.sabercon.algorithm.q400.q360;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Data Stream as Disjoint Intervals
 * <p>
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.
 * <p>
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
 * <p>
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * <p>
 * Follow up:
 * <p>
 * What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 *
 * @author ywk
 * @date 2020-04-27
 */
public class Q352 {

    private TreeSet<int[]> set;

    /**
     * Initialize your data structure here.
     */
    public Q352() {
        set = new TreeSet<>(Comparator.comparingInt(e -> e[0]));
    }

    public void addNum(int val) {
        int[] vals = new int[2];
        vals[0] = val;
        vals[1] = val;
        int[] floor = set.floor(vals);
        int[] ceiling = set.ceiling(vals);
        if (floor == null || floor[1] + 1 < val) {
            if (ceiling != null && ceiling[0] - 1 == val) {
                ceiling[0] = val;
            } else {
                set.add(vals);
            }
        } else if (floor[1] + 1 == val) {
            if (ceiling != null && ceiling[0] - 1 == val) {
                floor[1] = ceiling[1];
                set.remove(ceiling);
            } else {
                floor[1] = val;
            }
        }
    }

    public int[][] getIntervals() {
        return set.toArray(new int[0][]);
    }
}
