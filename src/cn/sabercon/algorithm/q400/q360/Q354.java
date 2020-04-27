package cn.sabercon.algorithm.q400.q360;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Russian Doll Envelopes
 * <p>
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h).
 * One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * <p>
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * <p>
 * Note:
 * Rotation is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 *
 * @author ywk
 * @date 2020-04-27
 */
public class Q354 {

    public int maxEnvelopes(int[][] envelopes) {
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        for (int[] envelope : envelopes) {
            map.computeIfAbsent(envelope[0], e -> new TreeSet<>()).add(envelope[1]);
        }
        return 0;
    }
}
