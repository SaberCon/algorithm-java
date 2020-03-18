package cn.sabercon.algorithm.q100.q90;

import java.util.Arrays;

/**
 * Maximal Rectangle
 * <p>
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 * <p>
 * Example:
 * Input:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * Output: 6
 *
 * @author ywk
 * @date 2020-03-18
 */
public class Q85 {

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int[] heights = new int[matrix[0].length];
        int[] lefts = new int[matrix[0].length];
        int[] rights = new int[matrix[0].length];
        Arrays.fill(rights, matrix[0].length);
        int begin = 0;
        int end = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                    lefts[j] = 0;
                    rights[j] = matrix[0].length;
                    end = 0;
                } else {
                    heights[j]++;
                    if (end == 0) {
                        begin = j;
                        end = j + 1;
                        while (end < matrix[0].length && matrix[i][end] != '0') {
                            end++;
                        }
                    }
                    lefts[j] = Math.max(lefts[j], begin);
                    rights[j] = Math.min(rights[j], end);
                    max = Math.max(max, heights[j] * (rights[j] - lefts[j]));
                }
            }
            end = 0;
        }
        return max;
    }
}
