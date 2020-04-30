package cn.sabercon.algorithm.q400.q400;

import javafx.util.Pair;

import java.util.*;

/**
 * Perfect Rectangle
 *
 * Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.
 *
 * Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2].
 * (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).
 *
 * Example 1:
 *
 * rectangles = [
 *   [1,1,3,3],
 *   [3,1,4,2],
 *   [3,2,4,4],
 *   [1,3,2,4],
 *   [2,3,3,4]
 * ]
 *
 * Return true. All 5 rectangles together form an exact cover of a rectangular region.
 *
 * Example 2:
 *
 * rectangles = [
 *   [1,1,2,3],
 *   [1,3,2,4],
 *   [3,1,4,2],
 *   [3,2,4,4]
 * ]
 *
 * Return false. Because there is a gap between the two rectangular regions.
 *
 * Example 3:
 *
 * rectangles = [
 *   [1,1,3,3],
 *   [3,1,4,2],
 *   [1,3,2,4],
 *   [3,2,4,4]
 * ]
 *
 * Return false. Because there is a gap in the top center.
 *
 * Example 4:
 *
 * rectangles = [
 *   [1,1,3,3],
 *   [3,1,4,2],
 *   [1,3,2,4],
 *   [2,2,4,4]
 * ]
 *
 * Return false. Because two of the rectangles overlap with each other.
 *
 * @author ywk
 * @date 2020-04-30
 */
public class Q391 {

    public static boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0) {
            return false;
        }
        Arrays.sort(rectangles, Comparator.comparingInt(a -> ((int[]) a)[0]).thenComparingInt(a -> ((int[]) a)[1]));
        TreeMap<Integer, TreeSet<Integer>> lines = new TreeMap<>();
        int startPoint = rectangles[0][0];
        int bottom = rectangles[0][1];
        int top = rectangles[0][3];
        for (int[] rectangle : rectangles) {
            if (rectangle[0] > startPoint) {
                break;
            }
            top = rectangle[3];
        }
        TreeSet<Integer> set = new TreeSet<>();
        set.add(bottom);
        set.add(top);
        lines.put(startPoint, set);
        for (int[] rectangle : rectangles) {
            if (!mergeLines(lines, rectangle)) {
                return false;
            }
        }
        return lines.size() == 1;
    }

    private static boolean mergeLines(TreeMap<Integer, TreeSet<Integer>> lines, int[] rectangle) {
        int bottom = rectangle[1];
        int top = rectangle[3];
        Map.Entry<Integer, TreeSet<Integer>> startEntry = lines.firstEntry();
        Integer startPoint = startEntry.getKey();
        TreeSet<Integer> startLine = startEntry.getValue();
        if (rectangle[0] != startPoint || bottom != startLine.pollFirst() || top > startLine.first()) {
            return false;
        }
        if (top == startLine.first()) {
            startLine.pollFirst();
            if (startLine.isEmpty()) {
                lines.remove(startPoint);
            }
        } else {
            startLine.add(top);
        }
        TreeSet<Integer> endLine = lines.computeIfAbsent(rectangle[2], k -> new TreeSet<>());
        if (endLine.contains(bottom)) {
            endLine.remove(bottom);
        } else {
            endLine.add(bottom);
        }
        if (endLine.contains(top)) {
            endLine.remove(top);
        } else {
            endLine.add(top);
        }
        return true;
    }


    public static void main(String[] args) {
        int[][] ints = {{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}};
        Arrays.sort(ints, Comparator.comparingInt(a -> ((int[]) a)[0]).thenComparingInt(a -> ((int[]) a)[1]));
        System.out.println(Arrays.deepToString(ints));
    }
}
