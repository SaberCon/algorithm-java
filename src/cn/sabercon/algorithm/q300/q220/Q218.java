package cn.sabercon.algorithm.q300.q220;

import javafx.util.Pair;

import java.util.*;

/**
 * The Skyline Problem
 * <p>
 * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance.
 * Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A),
 * write a program to output the skyline formed by these buildings collectively (Figure B).
 * <p>
 * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi],
 * where Li and Ri are the x coordinates of the left and right edge of the ith building,
 * respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0.
 * You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
 * <p>
 * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * <p>
 * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1, y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline.
 * A key point is the left endpoint of a horizontal line segment. Note that the last key point,
 * where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height.
 * Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
 * <p>
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24 0] ].
 * <p>
 * Notes:
 * <p>
 * The number of buildings in any input list is guaranteed to be in the range [0, 10000].
 * The input list is already sorted in ascending order by the left x position Li.
 * The output list must be sorted by the x position.
 * There must be no consecutive horizontal lines of equal height in the output skyline.
 * For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable;
 * the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
 *
 * @author ywk
 * @date 2020-04-05
 */
public class Q218 {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<Pair<Integer, Integer>> line = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey() == 0 ? b.getValue() - a.getValue() : a.getKey() - b.getKey());
        PriorityQueue<Integer> heights = new PriorityQueue<>(Comparator.reverseOrder());
        heights.add(0);
        for (int[] building : buildings) {
            line.add(new Pair<>(building[0], building[2]));
            line.add(new Pair<>(building[1], -building[2]));
        }
        while (!line.isEmpty()) {
            Pair<Integer, Integer> pair = line.poll();
            Integer key = pair.getKey();
            Integer value = pair.getValue();
            if (value > 0) {
                if (heights.peek() < value) {
                    ans.add(Arrays.asList(key, value));
                }
                heights.add(value);
            } else {
                heights.remove(-value);
                if (heights.peek() < -value && !ans.get(ans.size() - 1).get(0).equals(key)) {
                    ans.add(Arrays.asList(key, heights.peek()));
                }
            }
        }
        return ans;
    }
}
