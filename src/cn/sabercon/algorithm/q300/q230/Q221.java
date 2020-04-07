package cn.sabercon.algorithm.q300.q230;

/**
 * Maximal Square
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 *
 * @author ywk
 * @date 2020-04-07
 */
public class Q221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        Integer[][] maxSquares = new Integer[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, getMaxSquare(matrix, maxSquares, i, j));
            }
        }
        return max * max;
    }

    private int getMaxSquare(char[][] matrix, Integer[][] maxSquares, int i, int j) {
        if (i == matrix.length || j == matrix[0].length) {
            return 0;
        }
        if (maxSquares[i][j] == null) {
            if (matrix[i][j] == '0') {
                maxSquares[i][j] = 0;
            } else {
                maxSquares[i][j] = Math.min(getMaxSquare(matrix, maxSquares, i + 1, j + 1),
                        Math.min(getMaxSquare(matrix, maxSquares, i + 1, j), getMaxSquare(matrix, maxSquares, i, j + 1))) + 1;
            }
        }
        return maxSquares[i][j];
    }
}
