package cn.sabercon.algorithm.q100.q60;

/**
 * Spiral Matrix II
 * <p>
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 *
 * @author ywk
 * @date 2020-03-15
 */
public class Q59 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int begin = 0;
        while (num < n * n) {
            for (int i = begin; i < n - begin; i++) {
                matrix[begin][i] = num++;
            }
            for (int i = begin + 1; i < n - begin - 1; i++) {
                matrix[i][n - begin - 1] = num++;
            }
            for (int i = n - begin - 1; i >= begin; i--) {
                matrix[n - begin - 1][i] = num++;
            }
            for (int i = n - begin - 2; i > begin; i--) {
                matrix[i][begin] = num++;
            }
            begin++;
        }
        if (num == n * n) {
            matrix[n / 2][n / 2] = num;
        }
        return matrix;
    }
}
