package cn.sabercon.algorithm.q400.q360;

import java.util.Collections;
import java.util.Map;
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
        if (envelopes.length == 0) {
            return 0;
        }
        TreeMap<Integer, TreeMap<Integer, Integer>> map = new TreeMap<>();
        for (int[] envelope : envelopes) {
            map.computeIfAbsent(envelope[0], e -> new TreeMap<>()).put(envelope[1], 0);
        }
        int max = 0;
        TreeMap<Integer, TreeMap<Integer, Integer>> tempMap = new TreeMap<>(map);
        for (Map.Entry<Integer, TreeMap<Integer, Integer>> entry : tempMap.entrySet()) {
            Integer currentWidth = entry.getKey();
            for (Integer currentHeight : entry.getValue().keySet()) {
                int currentMax = 0;
                for (Map.Entry<Integer, TreeMap<Integer, Integer>> mapEntry : tempMap.entrySet()) {
                    if (mapEntry.getKey() >= currentWidth) {
                        break;
                    }
                    Map.Entry<Integer, Integer> lowerEntry = mapEntry.getValue().lowerEntry(currentHeight);
                    if (lowerEntry != null) {
                        currentMax = Math.max(currentMax, lowerEntry.getValue() + 1);
                    }
                }
                map.get(currentWidth).put(currentHeight, currentMax);
                max = Math.max(max, currentMax);
            }
        }
        return max + 1;
    }
}
