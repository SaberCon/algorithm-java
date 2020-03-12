package cn.sabercon.algorithm.q100.q50;

import java.util.TreeMap;

/**
 * Trapping Rain Water
 * <p>
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * <p>
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * @author ywk
 * @date 2020-03-12
 */
public class Q42 {

    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int area = 0;
        TreeMap<Integer, Integer> leftMap = new TreeMap<>();
        TreeMap<Integer, Integer> rightMap = new TreeMap<>();
        for (int i = 0; i < height.length; i++) {
            leftMap.putIfAbsent(height[i], i);
            rightMap.put(height[i], i);
        }
        int left = leftMap.pollLastEntry().getValue();
        int right = rightMap.pollLastEntry().getValue();
        area += computeArea(height, left, right);
        while (!leftMap.isEmpty() && left != 0) {
            int begin = leftMap.pollLastEntry().getValue();
            if (begin < left) {
                area += computeArea(height, begin, left);
                left = begin;
            }
        }
        while (!rightMap.isEmpty() && right != height.length - 1) {
            int end = rightMap.pollLastEntry().getValue();
            if (end > right) {
                area += computeArea(height, right, end);
                right = end;
            }
        }
        return area;
    }

    private int computeArea(int[] height, int begin, int end) {
        int area = 0;
        int ceil = Math.min(height[begin], height[end]);
        for (int i = begin + 1; i < end; i++) {
            area += ceil - height[i];
        }
        return area;
    }
}
