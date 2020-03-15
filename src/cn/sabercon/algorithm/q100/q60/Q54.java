package cn.sabercon.algorithm.q100.q60;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix
 * <p>
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * <p>
 * Example 2:
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * @author ywk
 * @date 2020-03-15
 */
public class Q54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        return spiral(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    private List<Integer> spiral(int[][] matrix, int row1, int row2, int col1, int col2) {
        ArrayList<Integer> result = new ArrayList<>((row2 - row1) * (col2 - col1));
        for (int i = col1; i <= col2; i++) {
            result.add(matrix[row1][i]);
        }
        for (int i = row1 + 1; i < row2; i++) {
            result.add(matrix[i][col2]);
        }
        if (row1 != row2) {
            for (int i = col2; i >= col1; i--) {
                result.add(matrix[row2][i]);
            }
        }
        if (col1 != col2) {
            for (int i = row2 - 1; i > row1; i--) {
                result.add(matrix[i][col1]);
            }
        }
        if (row2 - row1 >= 2 && col2 - col1 >= 2) {
            result.addAll(spiral(matrix, row1 + 1, row2 - 1, col1 + 1, col2 - 1));
        }
        return result;
    }
}
